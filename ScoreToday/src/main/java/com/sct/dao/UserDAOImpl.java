package com.sct.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sct.vo.UserInfoVO;
import com.sct.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.sct.mapper.UserMapper";

	@Override
	public UserVO getUser(UserVO vo) {
		
		return sqlSession.selectOne(namespace+".selectUser", vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		sqlSession.insert(namespace+".insertUser", vo);

	}

	@Override
	public void deleteUser(UserVO vo) {
		sqlSession.delete(namespace+".deleteUser", vo);
		
	}

	@Override
	public int getUseq(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectUseq", vo);
	}

	

}
