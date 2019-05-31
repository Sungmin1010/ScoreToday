package com.sct.vo;

public class UserVO {

	private int useq;
	private String id;
	private String name;
	private String email;
	private String password;
	private String joindate;
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
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "User [useq=" + useq + ", id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", joindate=" + joindate + "]";
	}
	
	
}
