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
		// TODO 새로운 점수를 DB에 인서트

	}

	@Override
	public int countScore() {
		// TODO Auto-generated method stub
		return 0;
		
	}

}
