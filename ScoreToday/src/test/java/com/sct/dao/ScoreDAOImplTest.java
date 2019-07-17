package com.sct.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sct.vo.ScoreVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WBE-INF/spring/**/root-context.xml"})

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
		vo.setTimecategory('a');
		vo.setUseq(1);
		//when : ��� ����
		dao.insertScore(vo);
		//then : ��� Ȯ��
		assertEquals(dao.countScore(), beforeCount+1);
		
		
	}

}
