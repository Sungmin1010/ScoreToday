package com.sct.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, ScoreVO> getThreeScores(Date date, UserInfoVO userinfo) {
		// TODO 세개의 score을 am, noon, pm 이라는 키 값을 갖는 map으로 리턴
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(date);
		UserDayScoreVO vo = new UserDayScoreVO(dao.getUseq(userinfo), today);
		List<ScoreVO> list = scoreDao.selectDayScore(vo);
		
		//make Map
		return makeScoreMap(list);
	}
	
	
	private Map<String, ScoreVO> makeScoreMap(List<ScoreVO> list) {
		HashMap<String, ScoreVO> map = new HashMap<>();
		map.put("am", new ScoreVO());
		map.put("noon", new ScoreVO());
		map.put("pm", new ScoreVO());
		for(ScoreVO score: list) {
			if(score.getTimecode().equals("a")) {
				map.put("am", score);
			}
			if(score.getTimecode().equals("n")) {
				map.put("noon", score);
			}
			if(score.getTimecode().equals("p")) {
				map.put("pm", score);
			}
		}
		return map;
	}

}
