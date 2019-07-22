package com.sct.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScoreController {

	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);
	
	@RequestMapping(value="/main/record", method=RequestMethod.GET)
	public String getRecord(@RequestParam(name="timecategory", defaultValue="x", required=false) char timecategory, Model model)throws Exception{
		
		String tc = makeTimeCategory(timecategory);
		model.addAttribute("timecategory", tc);
		
		return "/main/record";
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
