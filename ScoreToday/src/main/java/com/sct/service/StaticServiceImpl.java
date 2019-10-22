package com.sct.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sct.dao.StaticDAO;
import com.sct.dao.UserDAO;
import com.sct.vo.StaticVO;
import com.sct.vo.UserInfoVO;

@Service
public class StaticServiceImpl implements StaticService {

	@Inject
	private StaticDAO staticDao ;
	
	@Inject
	private UserDAO userDao;
	
	@Override
	public List<StaticVO> getScores(UserInfoVO vo, Map<String, Object> map) {
		map.put("useq", Integer.toString(userDao.getUseq(vo)));
		return staticDao.getScoreMap(map);
		
	}

}
