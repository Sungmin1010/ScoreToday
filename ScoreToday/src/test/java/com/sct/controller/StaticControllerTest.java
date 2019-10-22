package com.sct.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sct.service.StaticService;
import com.sct.vo.StaticVO;
import com.sct.vo.UserInfoVO;


//https://victorydntmd.tistory.com/172
public class StaticControllerTest {
	
	@Mock
	private StaticService staticService;
	
	@InjectMocks
	private StaticController staticController;
	
	private MockMvc mockMvc;
	
	@Inject
	protected ResourceLoader resourceLoader;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		//RestController 테스트 이므로 사용 안함
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(staticController)
				.build();

	}
	
	@Test
	public void test_ajax_with_three_scores() throws Exception {
		//given ajax 통신 으로 body에 데이터 ... 
		
		List<StaticVO> resList = new ArrayList<>();
		resList.add(new StaticVO("2019-09-01",5.7F, 6.0F, 7.3F ));
		resList.add(new StaticVO("2019-09-02", 5.7F, 4.3F, 4.7F ));
		resList.add(new StaticVO("2019-09-03", 4.7F, 6.7F, 5.0F ));
		resList.add(new StaticVO("2019-09-04", 4.3F, 5.7F, 2.3F));
		resList.add(new StaticVO("2019-09-05", 7.0F, 3.3F, 6.3F));
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String resjson = ow.writeValueAsString(resList);
		System.out.println(resjson);
		
		when(staticService.getScores(any(UserInfoVO.class), any(Map.class))).thenReturn(resList);
		String json = "{\"startDate\":\"2019-9-1\", \"endDate\":\"2019-9-5\", \"category\":[\"bodyscore\", \"mindscore\", \"mentalscore\"]}";
		//when
		ResultActions resultActions = mockMvc.perform(get("/static/user/testid/scores")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
				.andDo(print());
		//then
		resultActions.andExpect(status().isOk())
		.andExpect(content().json(resjson));
		
		
		

	}
	
	protected String readJson(final String path) throws IOException{
		final InputStream  inputStream = resourceLoader.getResource(path).getInputStream();
		return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
	}

}
