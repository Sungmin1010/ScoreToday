package com.sct.vo;

import java.util.Date;

public class ScoreVO {
	
	private int sseq;
	private int bodyscore;
	private int mindscore;
	private int mentalscore;
	private Date scoredate;
	private String timecode;
	private int useq;
	
	private String tc;
	
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
		makeTimecategory(tc);
		
	}
	private void makeTimecategory(String tc) {
		if(tc.equals("AM")) {
			setTimecode("a");
		}
		if(tc.equals("NOON")) {
			setTimecode("n");
		}
		if(tc.equals("PM")) {
			setTimecode("p");
		}
		
		
	}
	
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
	public String getTimecode() {
		return timecode;
	}
	public void setTimecode(String timecode) {
		this.timecode = timecode;
	}
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	@Override
	public String toString() {
		return "ScoreVO [sseq=" + sseq + ", bodyscore=" + bodyscore + ", mindscore=" + mindscore + ", mentalscore="
				+ mentalscore + ", scoredate=" + scoredate + ", timecategory=" + timecode + ", useq=" + useq + "]";
	}
	
	
	
	

}
