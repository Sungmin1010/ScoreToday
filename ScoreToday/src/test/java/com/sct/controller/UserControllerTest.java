package com.sct.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sct.service.UserService;

//@ContextConfiguration(locations = "/test-context.xml") //locations = "/test-context.xml"

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserControllerTest {
	
	@Inject
	private WebApplicationContext webApplicationContext;
	
	
	
	MockMvc mockMvc;
	
	//UserService service; 
	
	//@Inject
	//UserController userController;
	
	
	
	/*@BeforeClass
	public static void before() {
		UserController controller = new UserController();
		service = mock(UserService.class);
		controller.setUserService(service);
		
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views");
		internalResourceViewResolver.setSuffix(".jsp");
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setViewResolvers(internalResourceViewResolver)
				.build();
	}*/
	
	//@Before
	/*
	 * public void setup2() { //service = mock(UserService.class);
	 * 
	 * InternalResourceViewResolver internalResourceViewResolver = new
	 * InternalResourceViewResolver();
	 * internalResourceViewResolver.setPrefix("/WEB-INF/views");
	 * internalResourceViewResolver.setSuffix(".jsp"); mockMvc =
	 * MockMvcBuilders.standaloneSetup(userController)
	 * .setViewResolvers(internalResourceViewResolver) .build(); }
	 */
	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
				
	}
	
	//@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("/home"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("/WEB-INF/views/home.jsp"));
	}
	
	@Test
	public void testLogin() throws Exception {
		mockMvc.perform(post("/login")
				.param("id", "testid")
				.param("password", "abcd1234"))
		.andExpect(status().isOk())
		.andExpect(view().name("main")).andDo(print());
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
