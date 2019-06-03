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
	
	private UserVO vo;
	
	@Before
	public void setUp() throws Exception{
		//insert test data
		this.vo = new UserVO();
		vo.setId("lmsg");
		vo.setName("¿”º∫πŒ");
		vo.setEmail("lmsgsm1@test.com");
		vo.setPassword("1234");
		//vo.setJoindate(new Date());
		
		dao.insertUser(vo);
		
	}

	@Test
	public void testGetUser() throws Exception {
		UserVO getVO = dao.getUser(vo);
		assertEquals(getVO.getId(), this.vo.getId());
		assertEquals(getVO.getName(), this.vo.getName());
		assertEquals(getVO.getEmail(), this.vo.getEmail());
		assertEquals(getVO.getPassword(), this.vo.getPassword());
		//assertEquals(getVO.getJoindate(), this.vo.getJoindate());
		
	}
	
	@Test
	public void testWrongPassword() throws Exception {
		fail();//TODO
	}
	
	@Test
	public void testWrongId() throws Exception {
		fail();//TODO
	}
	
	
	@Test
	public void testInsertUser() throws Exception {
		fail();//TODO
		
	}
	
	@After
	public void tearDown() throws Exception{
		dao.deleteUser(vo);
	}

}
