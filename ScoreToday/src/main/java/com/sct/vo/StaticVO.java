package com.sct.vo;

public class StaticVO {

	private String date;
	private Float bodyscore;
	private Float mindscore;
	private Float mentalscore;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getBodyscore() {
		return bodyscore;
	}
	public void setBodyscore(Float bodyscore) {
		this.bodyscore = bodyscore;
	}
	public Float getMindscore() {
		return mindscore;
	}
	public void setMindscore(Float mindscore) {
		this.mindscore = mindscore;
	}
	public Float getMentalscore() {
		return mentalscore;
	}
	public void setMentalscore(Float mentalscore) {
		this.mentalscore = mentalscore;
	}
	@Override
	public String toString() {
		return "StaticVO [date=" + date + ", bodyscore=" + bodyscore + ", mindscore=" + mindscore + ", mentalscore="
				+ mentalscore + "]";
	}
	public StaticVO(String date, Float bodyscore, Float mindscore, Float mentalscore) {
		super();
		this.date = date;
		this.bodyscore = bodyscore;
		this.mindscore = mindscore;
		this.mentalscore = mentalscore;
	}
	public StaticVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
