package com.sct.vo;

import java.util.Date;

public class UserVO {

	private int useq;
	private String id;
	private String name;
	private String email;
	private String password;
	private Date joindate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "User [useq=" + useq + ", id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", joindate=" + joindate + "]";
	}
	
	
}
