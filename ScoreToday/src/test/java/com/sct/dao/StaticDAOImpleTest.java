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

	//������ �Ⱓ ���� 3���� �������� ����� ����������
	@Test
	public void test() throws Exception {
		//given ��������
		//when ��ɼ���
		dao.getScore() //return list or map
		//then ���Ȯ��
		fail();
	}
	
	//������ �Ⱓ ���� 2���� �������� ����� ����������
	
	
}
