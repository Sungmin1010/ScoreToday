package com.sct.dao;



import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sct.vo.ScoreVO;

@Repository
public class ScoreDAOImpl implements ScoreDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.sct.mapper.ScoreMapper";

	@Override
	public void insertScore(ScoreVO vo) {
		session.insert(namespace+".insertScore", vo);

	}

	@Override
	public int countScore() {
		
		return session.selectOne(namespace+".countAllScore");
		
	}

}
