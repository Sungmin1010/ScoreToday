package com.sct.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sct.dao.ScoreDAO;
import com.sct.dao.UserDAO;
import com.sct.vo.ScoreVO;
import com.sct.vo.UserInfoVO;
@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Inject
	ScoreDAO dao;

	@Inject
	UserDAO userDao;
	
	@Override
	public void addScore(ScoreVO vo, UserInfoVO userinfo) {
		// userinfo에서 id값을 이용해서 useq를 알아내고 그 값을 score과 함께 table에 insert 한다.
		vo.setUseq(userDao.getUseq(userinfo));
		dao.insertScore(vo);
		
	}

	

}
