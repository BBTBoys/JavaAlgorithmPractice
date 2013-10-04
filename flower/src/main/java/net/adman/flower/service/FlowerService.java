package net.adman.flower.service;

import java.text.ParseException;
import java.util.List;

import net.adman.flower.model.Duration;
import net.adman.flower.model.Flower;


public interface FlowerService {
	
	List<Flower> selectListByDurationId(Integer durationId);

	List<Flower> selectListWithOptimalResult(Duration duration, List<Flower> rawFlowerList) throws ParseException;
}
