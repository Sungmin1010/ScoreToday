package com.sct.service;

import com.sct.vo.UserVO;

public interface UserService {
	
	public UserVO login(UserVO vo);
	
	public void regist(UserVO vo);
	
	public void remove(UserVO vo);

}
