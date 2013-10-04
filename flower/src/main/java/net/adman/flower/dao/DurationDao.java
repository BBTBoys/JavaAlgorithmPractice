package net.adman.flower.dao;

import net.adman.flower.model.Duration;

public interface DurationDao {

	Duration selectByStartAndEndDate(String startDate, String endDate);
}
