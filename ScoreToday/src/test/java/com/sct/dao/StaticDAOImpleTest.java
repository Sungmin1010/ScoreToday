package com.sct.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class StaticDAOImpleTest {
	
	@Inject
	StaticDAO dao;

	//지정된 기간 동안 3가지 점수들의 평균을 가져오는지
	@Test
	public void test() throws Exception {
		//given 선행조건
		//when 기능수행
		dao.getScore() //return list or map
		//then 결과확인
		fail();
	}
	
	//지정된 기간 동안 2가지 점수들의 평균을 가져오는지
	
	
}
