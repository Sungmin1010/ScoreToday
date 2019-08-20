package com.sct.controller;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sct.service.ScoreService;
import com.sct.vo.ScoreVO;
import com.sct.vo.UserInfoVO;
import com.sct.vo.UserVO;

public class ScoreControllerTest {
	
	@Mock
	private ScoreService scoreService;
	
	@InjectMocks
	private ScoreController scoreController;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(scoreController)
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
	
	//@Test --> 삭제 요망
	public void testPostRecord() throws Exception {
		//given : record bodyscore:10, mindscore10, mentalscore10, timecategory:a, useq:1
		//when : request /main/record POST
		//then : status OK, view main/main
		ScoreVO mockScoreVo = mock(ScoreVO.class);
		UserInfoVO mockUserInfo = mock(UserInfoVO.class);
		//when(scoreService.addScore(any(ScoreVO.class))).thenReturn
		RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/main/record")
														.requestAttr("scoreVO", mockScoreVo)
														.sessionAttr("userInfo", mockUserInfo);
		mockMvc.perform(reqBuilder)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name(is("main/main")));
		
		
	}
	
	@Test
	public void testPostRecordWithRedirect() throws Exception {
		//given : record bodyscore:10, mindscore10, mentalscore10, timecategory:a, useq:1
		//when : request /main/record POST
		//then : status OK, Attribute "msg":"success", redirect: /main
		ScoreVO mockScoreVo = mock(ScoreVO.class);
		UserInfoVO mockUserInfo = mock(UserInfoVO.class);
		RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/main/record")
				.requestAttr("scoreVO", mockScoreVo)
				.sessionAttr("userInfo", mockUserInfo);
		
		mockMvc.perform(reqBuilder)
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(flash().attribute("msg", "success"));
		
		verify(scoreService).addScore(any(ScoreVO.class), any(UserInfoVO.class));
		
		//useq가 1인 사람의 score가 1개 증가 되었는지. (더 자세하게 한다면 scoreVO 결과와 동일하는지)
		//fail();
	}

}
