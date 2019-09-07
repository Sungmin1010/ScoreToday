package com.sct.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sct.dao.ScoreDAO;
import com.sct.dao.UserDAO;
import com.sct.vo.ScoreVO;
import com.sct.vo.UserDayScoreVO;
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

	@Override
	public boolean checkBeforeAddScore(Date date, UserInfoVO userinfo) {
		// TODO ������ add �ϱ� ���� ���� ��ϵ� ������ 3�� �̻��̸� add ����
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(date);
		UserDayScoreVO userDayScore = new UserDayScoreVO(userDao.getUseq(userinfo), today);
		int countScore = dao.selectDayScore(userDayScore).size();
		if(countScore < 3) {
			return true;
		}
		return false;
		
	}

	

}
