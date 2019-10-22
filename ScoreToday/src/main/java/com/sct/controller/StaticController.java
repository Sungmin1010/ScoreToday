package com.sct.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sct.service.StaticService;
import com.sct.vo.StaticVO;
import com.sct.vo.UserInfoVO;

@RestController
@RequestMapping("/static")
public class StaticController {
	
	private static final Logger logger = LoggerFactory.getLogger(StaticController.class);
	
	@Inject
	private StaticService service;
	
	@RequestMapping(value="/user/{id}/scores", method=RequestMethod.POST)
	public List<StaticVO> scoresList(@PathVariable("id") String id, @RequestBody Map<String, Object> requestData, HttpSession session) throws Exception {
		UserInfoVO userinfo = (UserInfoVO) session.getAttribute("userInfo");
		logger.info("startDate : "+ requestData.get("startDate")+ ", id : "+ id);
		List<StaticVO> res = service.getScores(userinfo, requestData);
		return res;
	}
	
	public Map<String, List<Object>> scoresMap() throws Exception {
		
		return null;
	}
	
}
