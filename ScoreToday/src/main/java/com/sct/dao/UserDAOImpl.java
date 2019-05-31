package com.sct.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sct.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.sct.mapper.UserMapper";

	@Override
	public UserVO getUser(UserVO vo) {
		return sqlSession.selectOne(namespace+".getUser");
	}

	@Override
	public void insertUser(UserVO vo) {
		sqlSession.insert(namespace+".insertUser", vo);

	}

}
