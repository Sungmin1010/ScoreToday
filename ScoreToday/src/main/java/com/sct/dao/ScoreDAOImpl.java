package com.sct.dao;

import org.springframework.stereotype.Repository;

import com.sct.vo.ScoreVO;

@Repository
public class ScoreDAOImpl implements ScoreDAO {

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
