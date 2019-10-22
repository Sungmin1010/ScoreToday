package com.sct.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.sct.service.UserService;
import com.sct.vo.ScoreVO;
import com.sct.vo.UserInfoVO;
import com.sct.vo.UserVO;

public class UserControllerStandaloneTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		InternalResourceViewResolver internalResourceViewResolver = new	InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController)
				.setViewResolvers(internalResourceViewResolver).build();
	}
	
	@Test
	public void testLogin2() throws Exception {
		UserVO expectedUser = new UserVO();
		expectedUser.setId("testid");
		expectedUser.setPassword("abcd1234");
		expectedUser.setEmail("test@mail.com");
		expectedUser.setName("sung");
		//UserInfoVO userInfo = new UserInfoVO("testid", "sung");
		
		when(userService.login(any(UserVO.class))).thenReturn(expectedUser);
		//RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/login").param("id", "testid").param("password", "abcd1234");
		mockMvc.perform(post("/main").param("id", "testid").param("password", "abcd1234"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("main/main"))
		.andExpect(request().sessionAttribute("userInfo", notNullValue()));
	}
	
	@Test
	public void testLogin_WorngIdOrPassword() throws Exception {
		//make stub : return userVO is null
		when(userService.login(any(UserVO.class))).thenReturn(any(UserVO.class));
		
		mockMvc.perform(post("/main").param("id", "wrongid").param("password", "abcd1234"))
		.andDo(print())
		.andExpect(status().is3xxRedirection()) //redirection is not OK status
		.andExpect(redirectedUrl("/"))
		.andExpect(flash().attribute("msg", "fail"));
	}
	
	@Test
	public void testMainPageWithUserScoreInOneDay() throws Exception {
		//given : id=testid 인 사람이 2019-08-20에 main페이지 GET할 경우, score점수를가져와서 attribute에 list로 넣는다
		UserInfoVO userInfo = new UserInfoVO("testid", "testname");
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/main").sessionAttr("userInfo", userInfo);
		List<ScoreVO> mockList = mock(List.class);
		when(userService.getScoresInOneDay(any(Date.class), any(UserInfoVO.class))).thenReturn(mockList);
		//when
		mockMvc.perform(reqBuilder)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("main/main"))
		.andExpect(model().attribute("scoreList", mockList));
		//then
	}
	
	@Test
	public void testMainPageWithThreeScore() throws Exception {
		//given
		UserInfoVO userInfo = new UserInfoVO("testid", "testname");
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/main").sessionAttr("userInfo", userInfo);
		
		//when
		ResultActions resultActions = mockMvc.perform(reqBuilder)
				.andDo(print());
		
		//then
		resultActions.andExpect(status().isOk())
		.andExpect(view().name("main/main"))
		//.andExpect(model().attributeExists("am", "noon", "pm"))
		.andExpect(model().attribute("am", any(ScoreVO.class)))
		.andExpect(model().attribute("noon", any(ScoreVO.class)))
		.andExpect(model().attribute("pm", any(ScoreVO.class)))
		.andDo(print())
		;
		
	}
	
	
	
	
	

}
