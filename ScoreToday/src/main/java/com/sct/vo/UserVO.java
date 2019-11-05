package com.sct.vo;

import java.util.Date;

public class UserVO {

	private int useq;
	private String id;
	private String email;
	private String pwd;
	private Date joindate;
	private Date modidate;
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	@Override
	public String toString() {
		return "UserVO [useq=" + useq + ", id=" + id + ", email=" + email + ", pwd=" + pwd + ", joindate=" + joindate
				+ ", modidate=" + modidate + "]";
	}
	
	
}
