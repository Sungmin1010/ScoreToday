package com.sct.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sct.vo.StaticVO;

@Repository
public class StaticDAOImpl implements StaticDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.sct.mapper.StaticMapper";

	@Override
	public List<StaticVO> getScoreMap(Map<String, Object> requestData) {
		
		List<StaticVO> scores = session.selectList(namespace+".testSelect", requestData);
		
		return scores;
	}

}
