package com.sct.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sct.service.UserService;
import com.sct.vo.UserVO;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, UserVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("입력 vo : "+ vo.toString());
		UserVO result = service.login(vo);
		if(result==null) {
			logger.info("존재하지 않는 회원정보");
			rttr.addFlashAttribute("msg", "fail");
			return "redirect:/";
		}
		model.addAttribute("userVO", result);
		return "main";
	}

	public void setUserService(UserService userService) {
		this.service = userService;
		
	}

}
