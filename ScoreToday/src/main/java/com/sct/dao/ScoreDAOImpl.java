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
		// TODO ���ο� ������ DB�� �μ�Ʈ

	}

	@Override
	public int countScore() {
		// TODO Auto-generated method stub
		return 0;
		
	}

}
