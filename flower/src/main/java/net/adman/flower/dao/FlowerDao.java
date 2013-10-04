package net.adman.flower.dao;

import java.util.List;

import net.adman.flower.model.Flower;

public interface FlowerDao {

	List<Flower> selectByDurationId(Integer durationId);
}
