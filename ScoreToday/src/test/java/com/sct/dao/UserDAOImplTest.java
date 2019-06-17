package com.sct.dao;

import static org.junit.Assert.*;

import java.util.Date;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sct.vo.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDAOImplTest {
	
	@Inject
	private UserDAO dao;
	
	private UserVO testData;
	
	@Before
	public void setUp() throws Exception{
		//insert test data
		this.testData = new UserVO();
		testData.setId("lmsg");
		testData.setName("임성민");
		testData.setEmail("lmsgsm1@test.com");
		testData.setPassword("1234");
		//vo.setJoindate(new Date());
		
		dao.insertUser(testData);
		
	}

	@Test
	public void testGetUser() throws Exception {
		//given : 선행조건 기술
		UserVO clientVO = new UserVO();
		clientVO.setId("lmsg");
		clientVO.setPassword("1234");
		//when : 기능 수행
		UserVO getVO = dao.getUser(clientVO);
		//then : 결과 확인
		assertEquals(getVO.getId(), clientVO.getId());
		//assertEquals(getVO.getName(), clientVO.getName());
		//assertEquals(getVO.getEmail(), clientVO.getEmail());
		assertEquals(getVO.getPassword(), clientVO.getPassword());
		//assertEquals(getVO.getJoindate(), this.vo.getJoindate());
		
	}
	
	@Test
	public void testWrongPassword() throws Exception {
		//given
		UserVO clientVO = new UserVO();
		clientVO.setId("lmsg");
		clientVO.setPassword("wrong");
		//when
		UserVO getvo = dao.getUser(clientVO);
		//then
		assertNull(getvo);
	}
	
	@Test
	public void testWrongId() throws Exception {
		//given
		UserVO clientVO = new UserVO();
		clientVO.setId("wrong");
		clientVO.setPassword("wrong");
		//when
		UserVO getvo = dao.getUser(clientVO);
		//then
		assertNull(getvo);
	}
	
	
	@After
	public void tearDown() throws Exception{
		dao.deleteUser(testData);
	}

}
