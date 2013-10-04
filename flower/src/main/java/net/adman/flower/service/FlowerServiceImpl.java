package net.adman.flower.service;

import java.text.ParseException;
import java.util.List;

import net.adman.flower.dao.FlowerDao;
import net.adman.flower.model.Duration;
import net.adman.flower.model.Flower;
import net.adman.flower.model.GardenManager;
import net.adman.flower.support.util.DateUtil;
import net.adman.flower.support.util.DateUtil.Format;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service
@Transactional(readOnly=true)
public class FlowerServiceImpl implements FlowerService {
	
	@Autowired private FlowerDao flowerDao;

	@Override
	public List<Flower> selectListByDurationId(Integer durationId) {
		if (durationId != null) {
			List<Flower> resultList = flowerDao.selectByDurationId(durationId);
			if (CollectionUtils.isNotEmpty(resultList)) {
				return resultList;
			}
		}
		return null;
	}

	@Override
	public List<Flower> selectListWithOptimalResult(Duration duration, List<Flower> rawFlowerList) throws ParseException {
		if (duration != null) {
			List<Flower> resultList = null;
			if (rawFlowerList != null) {
				resultList = rawFlowerList;
			} else {
				resultList = selectListByDurationId(duration.getId());
			}
			
			if (CollectionUtils.isNotEmpty(resultList)) {
				List<Flower> flowerProviderChain = Lists.newArrayList();
				
				GardenManager gardenManager = new GardenManager(resultList, duration);
				
				Flower resultFlower = gardenManager.getFirstFlower();
				
				while(DateUtil.parse(resultFlower.getFallingDay(), Format.Date).getTime() <= DateUtil.parse(gardenManager.getDuration().getEndDate(), Format.Date).getTime()) {
					flowerProviderChain.add(resultFlower);
					resultFlower = getNextFlower(gardenManager, resultFlower);
				}
				
				flowerProviderChain.add(resultFlower);
				return flowerProviderChain;
			}
		}
		return null;
	}
	
	private Flower getNextFlower(GardenManager gardenManager, Flower flower) throws ParseException {
		return getFallingFlower(getCandidates(gardenManager, flower));
	}

	private Flower getFallingFlower(List<Flower> candidates) throws ParseException {
		if (candidates != null && candidates.size() > 0) {
			if (candidates.size() == 1) {
				return candidates.get(0);
			}
			Flower flower = candidates.get(0);
			
			for(Flower testFlower : candidates) {
				if (DateUtil.parse(flower.getFallingDay(), Format.Date).getTime() < DateUtil.parse(testFlower.getFallingDay(), Format.Date).getTime()) {
					flower = testFlower;
				}
			}
			
			return flower;
		}
		return null;
	}

	private List<Flower> getCandidates(GardenManager gardenManager, Flower flower) throws ParseException {
		List<Flower> candidates = Lists.newArrayList();
		for(Flower rawFlower : gardenManager.getFlowerList()) {
			if (DateUtil.parse(flower.getFallingDay(), Format.Date).getTime() >= DateUtil.parse(rawFlower.getBloomingDay(), Format.Date).getTime()
					&& DateUtil.parse(flower.getFallingDay(), Format.Date).getTime() < DateUtil.parse(rawFlower.getFallingDay(), Format.Date).getTime()) {
				candidates.add(rawFlower);
			}
		}
		return candidates;
	}

}
