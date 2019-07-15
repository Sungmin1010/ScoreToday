package com.sct.controller;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.sct.service.UserService;
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
		UserInfoVO userInfo = new UserInfoVO("testid", "sung");
		
		when(userService.login(any(UserVO.class))).thenReturn(expectedUser);
		//RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/login").param("id", "testid").param("password", "abcd1234");
		mockMvc.perform(post("/login").param("id", "testid").param("password", "abcd1234"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("main/main"))
		.andExpect(request().sessionAttribute("userInfo", notNullValue()));
	}
	
	@Test
	public void testLogin_WorngIdOrPassword() throws Exception {
		//make stub : return userVO is null
		when(userService.login(any(UserVO.class))).thenReturn(any(UserVO.class));
		
		mockMvc.perform(post("/login").param("id", "wrongid").param("password", "abcd1234"))
		.andDo(print())
		.andExpect(status().is3xxRedirection()) //redirection is not OK status
		.andExpect(redirectedUrl("/"))
		.andExpect(flash().attribute("msg", "fail"));
	}
	
	

}
