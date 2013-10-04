package net.adman.flower.dao.mybatis;

import java.util.Map;

import net.adman.flower.dao.DurationDao;
import net.adman.flower.model.Duration;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;

@Repository("durationDao")
public class DurationDaoImpl extends SqlSessionDaoSupport implements DurationDao {

	@Override
	public Duration selectByStartAndEndDate(String startDate, String endDate) {
		if (StringUtils.isNotBlank(startDate)
				&& StringUtils.isNotBlank(endDate)) {
			Map<String, String> map = Maps.newHashMap();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			return getSqlSession().selectOne("Duration.selectByStartAndEndDate", map);
		}
		return null;
	}

}
