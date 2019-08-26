package com.sct.vo;


public class UserDayScoreVO {
	private int useq;
	private String today;  //'yyyy-MM-dd'
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public UserDayScoreVO(int useq, String today) {
		super();
		this.useq = useq;
		this.today = today;
	}
	public UserDayScoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
