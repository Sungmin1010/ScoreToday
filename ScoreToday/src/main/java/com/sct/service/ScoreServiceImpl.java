package com.sct.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sct.dao.ScoreDAO;
import com.sct.vo.ScoreVO;
@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Inject
	ScoreDAO dao;

	@Override
	public void addScore(ScoreVO vo) {
		dao.insertScore(vo);
		
	}

	

}
