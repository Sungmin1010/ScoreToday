package com.sct.service;

import java.util.Date;

import com.sct.vo.ScoreVO;
import com.sct.vo.UserInfoVO;

public interface ScoreService {
	
	public void addScore(ScoreVO vo, UserInfoVO userinfo);
	
	public boolean checkBeforeAddScore(Date date, UserInfoVO userinfo);

}
