package com.sct.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sct.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class) //MockitoJUnitRunner.class
public class UserControllerStandaloneTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		//userController.setUserService(userService);
		
		InternalResourceViewResolver internalResourceViewResolver = new	InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views");
		internalResourceViewResolver.setSuffix(".jsp");
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController)
				.setViewResolvers(internalResourceViewResolver).build();
	}
	
	@Test
	public void testLogin2() throws Exception {
		RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/login").param("id", "testid").param("password", "abcd1234");
		mockMvc.perform(reqBuilder).andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("main"));
	}

}
