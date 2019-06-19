package com.sct.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sct.dao.UserDAO;
import com.sct.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(UserVO vo) {
		return dao.getUser(vo);
	}

	@Override
	public void regist(UserVO vo) {
		dao.insertUser(vo);

	}

	@Override
	public void remove(UserVO vo) {
		dao.deleteUser(vo);

	}

}
