package com.hy.ly.po;

public class AdminUser {

	private Integer adminNo;
	private String adminAcount;
	private String password;
	
	public Integer getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminAcount() {
		return adminAcount;
	}
	public void setAdminAcount(String adminAcount) {
		this.adminAcount = adminAcount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AdminUser() {
		super();
	}
	public AdminUser(Integer adminNo, String adminAcount, String password) {
		super();
		this.adminNo = adminNo;
		this.adminAcount = adminAcount;
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminUser [adminNo=" + adminNo + ", adminAcount=" + adminAcount + ", password=" + password + "]";
	}
	
}
