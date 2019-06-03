package com.sct.dao;

import com.sct.vo.UserVO;

public interface UserDAO {
	
	public UserVO getUser(UserVO vo);
	
	public void insertUser(UserVO vo);
	
	public void deleteUser(UserVO vo);

}
