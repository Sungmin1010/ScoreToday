package com.sct.dao;

import com.sct.vo.ScoreVO;

public interface ScoreDAO {
	
	public void insertScore(ScoreVO vo);
	
	public int countScore();

}
