package com.sct.dao;

import java.util.List;

import com.sct.vo.ScoreVO;
import com.sct.vo.UserDayScoreVO;

public interface ScoreDAO {
	
	public void insertScore(ScoreVO vo);
	
	public int countScore();

	public List<ScoreVO> selectDayScore(UserDayScoreVO vo);

}
