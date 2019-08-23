package com.sct.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sct.vo.ScoreVO;
import com.sct.vo.UserDayScoreVO;

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

	@Override
	public List<ScoreVO> selectDayScore(UserDayScoreVO vo) {
		
		return session.selectList(namespace+".selectDayScore", vo);
	}

}
