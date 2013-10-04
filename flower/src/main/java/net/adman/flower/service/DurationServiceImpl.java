package net.adman.flower.service;

import net.adman.flower.dao.DurationDao;
import net.adman.flower.model.Duration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DurationServiceImpl implements DurationService {
	
	@Autowired private DurationDao durationDao;

	@Override
	public Duration selectByStartAndEndDate(String startDate, String endDate) {
		if (StringUtils.isNotBlank(startDate)
				&& StringUtils.isNotBlank(endDate)) {
			return durationDao.selectByStartAndEndDate(startDate, endDate);
		}
		return null;
	}

}
