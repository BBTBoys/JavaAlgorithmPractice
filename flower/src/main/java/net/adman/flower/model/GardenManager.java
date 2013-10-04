package net.adman.flower.model;

import java.text.ParseException;
import java.util.List;

import net.adman.flower.support.util.DateUtil;
import net.adman.flower.support.util.DateUtil.Format;

import com.google.common.collect.Lists;

public class GardenManager {

	private List<Flower> flowerList;
	private Duration duration;
	
	public GardenManager() {
		
	}
	
	public GardenManager(List<Flower> flowerList, Duration duration) {
		this.flowerList = flowerList;
		this.duration = duration;
	}
	
	public Flower getFirstFlower() throws ParseException {
		List<Flower> candi = Lists.newArrayList();
		for(Flower flower : this.flowerList) {
			if (DateUtil.parse(this.duration.getStartDate(), Format.Date).getTime() >= DateUtil.parse(flower.getBloomingDay(), Format.Date).getTime()) {
				candi.add(flower);
			}
		}
		
		Flower testFlower = candi.get(0);
		for(Flower flower : candi) {
			if (DateUtil.parse(testFlower.getFallingDay(), Format.Date).getTime() < DateUtil.parse(flower.getFallingDay(), Format.Date).getTime()) {
				testFlower = flower;
			}
		}
		return testFlower;
	}
	
	public List<Flower> getFlowerList() {
		return flowerList;
	}

	public void setFlowerList(List<Flower> flowerList) {
		this.flowerList = flowerList;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	
	
}
