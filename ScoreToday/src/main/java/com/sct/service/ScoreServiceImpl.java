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
		// userinfo에서 id값을 이용해서 useq를 알아내고 그 값을 score과 함께 table에 insert 한다.
		vo.setUseq(userDao.getUseq(userinfo));
		dao.insertScore(vo);
		
	}

	@Override
	public boolean checkBeforeAddScore(Date date, UserInfoVO userinfo) {
		// TODO 점수를 add 하기 전에 오늘 기록된 점수가 3개 이상이면 add 못함
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
