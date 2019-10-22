package com.sct.service;

import java.util.List;
import java.util.Map;

import com.sct.vo.StaticVO;
import com.sct.vo.UserInfoVO;

public interface StaticService {
	
	List<StaticVO> getScores(UserInfoVO vo, Map<String, Object> map);

}
