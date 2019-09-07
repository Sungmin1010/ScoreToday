package com.sct.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sct.vo.ScoreVO;
import com.sct.vo.UserDayScoreVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ScoreDAOImplTest {
	
	@Inject
	private ScoreDAO dao;
	
	@Transactional
	@Test
	public void testInsertScore() throws Exception {
		//given : �������� ���
		int beforeCount = dao.countScore();
		ScoreVO vo = new ScoreVO();
		vo.setBodyscore(10);
		vo.setMindscore(10);
		vo.setMentalscore(10);
		vo.setTimecode("a");
		vo.setUseq(1);
		//when : ��� ����
		dao.insertScore(vo);
		//then : ��� Ȯ��
		assertEquals(dao.countScore(), beforeCount+1);
		
		
	}
	
	@Test
	public void testSelectScoreInOneDay() throws Exception{
		//given : �������� ���
		//useq�� 1�� ������� 2019�� 8�� 20�� �Է��� ������ 2�� �����Ѵ�.
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//Date date = formatter.parse("2019-08-20");
		UserDayScoreVO vo = new UserDayScoreVO(1, "2019-08-20");
		
		//when : ��� ����
		List<ScoreVO> scoreList = dao.selectDayScore(vo);
		
		//then : ��� Ȯ��
		assertThat(scoreList.size(), is(2));
		assertThat(scoreList.get(0).getBodyscore(), is(10));
		assertThat(scoreList.get(1).getBodyscore(), is(8));
	}
	

}
