package com.sct.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sct.service.ScoreService;
import com.sct.vo.ScoreVO;
import com.sct.vo.UserInfoVO;

@Controller
public class ScoreController {

	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);
	
	@Inject
	private ScoreService service;
	
	@RequestMapping(value="/main/record", method=RequestMethod.GET)
	public String getRecord(@RequestParam(name="timecategory", defaultValue="none", required=true) String timecategory, Model model, RedirectAttributes rttr)throws Exception{
		
		//String tc = makeTimeCategory(timecategory);
		if(timecategory.equals("AM") || timecategory.equals("NOON") || timecategory.equals("PM")) {
			model.addAttribute("timecategory", timecategory);
			return "main/record";
		}
		rttr.addFlashAttribute("msg", "attribute-error");
		return "redirect:/main";
		
	}
	
	@RequestMapping(value="/main/record", method=RequestMethod.POST)
	public String postRecord(ScoreVO scoreVO, HttpSession session, RedirectAttributes rttr)throws Exception{
		//TODO : 리팩토링 & 테스트 부분에 서비스 메소드 verify 코드 추가
		UserInfoVO userinfo = (UserInfoVO) session.getAttribute("userInfo");
		logger.info("[ScoreVO]"+scoreVO);
		if(service.checkBeforeAddScore(new Date(), userinfo)) {
			service.addScore(scoreVO, userinfo);
			rttr.addFlashAttribute("msg", "success");
			return "redirect:/main";
		}
		rttr.addFlashAttribute("msg", "score-error");
		return "redirect:/main";
		
		
		
		//return "main/main";
	}

	private String makeTimeCategory(char timecategory) {
		if(timecategory=='a') {
			return "AM";
		}
		if(timecategory=='n') {
			return "NOON";
		}
		if(timecategory=='p') {
			return "PM";
		}
		if(timecategory=='x') {
			return "";
		}
		
		return null;
	}
	
	
}
