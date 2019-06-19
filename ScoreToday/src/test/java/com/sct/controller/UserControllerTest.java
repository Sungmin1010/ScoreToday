package com.sct.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sct.service.UserService;

public class UserControllerTest {
	
	static MockMvc mockMvc;
	static UserService service;
	
	@Before
	public void before() {
		UserController controller = new UserController();
		service = mock(UserService.class);
		controller.setUserService(service);
		
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views");
		internalResourceViewResolver.setSuffix(".jsp");
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setViewResolvers(internalResourceViewResolver)
				.build();
	}
	
	@Test
	public void testLogin() throws Exception {
		fail();//TODO 
	}
	
	@Test
	public void testLogin_WrongId() throws Exception {
		fail();//TODO
	}
	
	@Test
	public void testLogin_WrongPassword() throws Exception {
		fail();//TODO
	}
	
	
	
	

}
