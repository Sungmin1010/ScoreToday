package com.sct.dao;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sct.vo.StaticVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class StaticDAOImpleTest {
	
	@Inject
	StaticDAO dao;

	//������ �Ⱓ ���� 3���� �������� ����� ����������
	@Test
	public void test() throws Exception {
		//given ��������
		  //2019-09-01 ~ 2019-09-05 
		Map<String, Object> requestData = new HashMap<>();
		requestData.put("startDate", "2019-09-01");
		requestData.put("endDate", "2019-09-05");
		requestData.put("useq", "1");
		
		//when ��ɼ���
		List<StaticVO> scores = dao.getScoreMap(requestData); //return list or map
		//then ���Ȯ��
		assertThat(scores.size()).isEqualTo(5);
		assertThat(scores.get(0).getBodyscore()).isEqualTo(5.7F);
		
		
		
	}
	
	//������ �Ⱓ ���� 2���� �������� ����� ����������
	
	
}
