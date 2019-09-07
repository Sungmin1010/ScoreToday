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
		//given : 선행조건 기술
		int beforeCount = dao.countScore();
		ScoreVO vo = new ScoreVO();
		vo.setBodyscore(10);
		vo.setMindscore(10);
		vo.setMentalscore(10);
		vo.setTimecode("a");
		vo.setUseq(1);
		//when : 기능 수행
		dao.insertScore(vo);
		//then : 결과 확인
		assertEquals(dao.countScore(), beforeCount+1);
		
		
	}
	
	@Test
	public void testSelectScoreInOneDay() throws Exception{
		//given : 선행조건 기술
		//useq가 1인 사용자의 2019년 8월 20일 입력한 점수가 2개 존재한다.
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//Date date = formatter.parse("2019-08-20");
		UserDayScoreVO vo = new UserDayScoreVO(1, "2019-08-20");
		
		//when : 기능 수행
		List<ScoreVO> scoreList = dao.selectDayScore(vo);
		
		//then : 결과 확인
		assertThat(scoreList.size(), is(2));
		assertThat(scoreList.get(0).getBodyscore(), is(10));
		assertThat(scoreList.get(1).getBodyscore(), is(8));
	}
	

}
