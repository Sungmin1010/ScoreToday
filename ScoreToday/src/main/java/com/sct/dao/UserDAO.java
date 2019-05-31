package com.sct.dao;

import com.sct.vo.UserVO;

public interface UserDAO {
	
	public UserVO getUser(UserVO user);
	
	public void insertUser(UserVO user);

}
