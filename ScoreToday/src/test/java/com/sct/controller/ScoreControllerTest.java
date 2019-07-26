package com.sct.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sct.service.ScoreService;

public class ScoreControllerTest {
	
	//@Mock
	//private ScoreService scoreService;
	
	//@Mock
	//private ScoreController scoreController;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() throws Exception{
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(new ScoreController())
				.setViewResolvers(internalResourceViewResolver).build();
	}
	
	@Test
	public void testGetRecord() throws Exception {
		//given : 선행조건 기술 - timecategory AM
		//when : 기능 수행 - 
		//then : 결과 확인 - status OK, model attribute AM, view main/record.jsp
		mockMvc.perform(get("/main/record").param("timecategory", "AM"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(model().attribute("timecategory", is("AM")))
				.andExpect(view().name("main/record"));
		
	}

}
