package com.sct.vo;

import java.util.Date;

public class ScoreVO {
	
	private int sseq;
	private int bodyscore;
	private int mindscore;
	private int mentalscore;
	private Date scoredate;
	private char timecategory;
	private int useq;
	
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public int getBodyscore() {
		return bodyscore;
	}
	public void setBodyscore(int bodyscore) {
		this.bodyscore = bodyscore;
	}
	public int getMindscore() {
		return mindscore;
	}
	public void setMindscore(int mindscore) {
		this.mindscore = mindscore;
	}
	public int getMentalscore() {
		return mentalscore;
	}
	public void setMentalscore(int mentalscore) {
		this.mentalscore = mentalscore;
	}
	public Date getScoredate() {
		return scoredate;
	}
	public void setScoredate(Date scoredate) {
		this.scoredate = scoredate;
	}
	public char getTimecategory() {
		return timecategory;
	}
	public void setTimecategory(char timecategory) {
		this.timecategory = timecategory;
	}
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	
	

}
