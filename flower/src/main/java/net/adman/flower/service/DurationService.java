package net.adman.flower.service;

import net.adman.flower.model.Duration;

public interface DurationService {

	Duration selectByStartAndEndDate(String startDate, String endDate);
}
