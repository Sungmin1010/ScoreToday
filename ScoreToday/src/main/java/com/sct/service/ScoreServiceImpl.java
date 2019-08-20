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
		// userinfo���� id���� �̿��ؼ� useq�� �˾Ƴ��� �� ���� score�� �Բ� table�� insert �Ѵ�.
		vo.setUseq(userDao.getUseq(userinfo));
		dao.insertScore(vo);
		
	}

	

}
