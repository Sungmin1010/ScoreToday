package com.sct.service;

import java.util.Date;
import java.util.List;

import com.sct.vo.ScoreVO;
import com.sct.vo.UserInfoVO;
import com.sct.vo.UserVO;

public interface UserService {
	
	public UserVO login(UserVO vo);
	
	public void regist(UserVO vo);
	
	public void remove(UserVO vo);
	
	public List<ScoreVO> getScoresInOneDay(Date date, UserInfoVO userinfo);

}
