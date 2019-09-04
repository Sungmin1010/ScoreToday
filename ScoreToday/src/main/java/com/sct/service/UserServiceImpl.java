package com.sct.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sct.dao.ScoreDAO;
import com.sct.dao.UserDAO;
import com.sct.vo.ScoreVO;
import com.sct.vo.UserDayScoreVO;
import com.sct.vo.UserInfoVO;
import com.sct.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;
	
	@Inject
	private ScoreDAO scoreDao;

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

	@Override
	public List<ScoreVO> getScoresInOneDay(Date date, UserInfoVO userinfo) {
		//make today String with SimpleDateFormat
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(date);
		//make vo with useq
		UserDayScoreVO vo = new UserDayScoreVO(dao.getUseq(userinfo), today);
		//get Score List 
		return scoreDao.selectDayScore(vo);
		
	}

}
