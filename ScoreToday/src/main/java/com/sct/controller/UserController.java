package com.sct.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sct.service.UserService;
import com.sct.vo.UserInfoVO;
import com.sct.vo.UserVO;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String login(Model model, UserVO vo, RedirectAttributes rttr, HttpSession session) throws Exception {
		logger.info("�Է� vo : "+ vo.toString());
		UserVO result = service.login(vo);
		if(result==null) {
			logger.info("�������� �ʴ� ȸ������");
			rttr.addFlashAttribute("msg", "fail");
			return "redirect:/";
		}
		UserInfoVO userInfo = new UserInfoVO(result.getId(), result.getName());
		session.setAttribute("userInfo", userInfo);
		return "main/main";
		//return "redirect:/main";
	}
	
	@RequestMapping(value="/main/static", method=RequestMethod.GET)
	public String userStatic()throws Exception{
		return "main/static";
	}
	
	@RequestMapping(value="/main/mypage", method=RequestMethod.GET)
	public String userMypage()throws Exception{
		return "main/mypage";
	}

	
	/*
	 * @RequestMapping(value="main", method=RequestMethod.GET) public String main()
	 * throws Exception{ logger.info("�α��� �Ϸ� �� �������� �̵�"); return "main/main"; }
	 */
	public void setUserService(UserService userService) {
		this.service = userService;
		
	}

}
