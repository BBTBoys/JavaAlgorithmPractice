package net.adman.flower.dao.mybatis;

import java.util.List;

import net.adman.flower.dao.FlowerDao;
import net.adman.flower.model.Flower;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("flowerDao")
public class FlowerDaoImpl extends SqlSessionDaoSupport implements FlowerDao {

	@Override
	public List<Flower> selectByDurationId(Integer durationId) {
		if (durationId != null) {
			return getSqlSession().selectList("Flower.selectListByDurationId", durationId);
		}
		return null;
	}

}
