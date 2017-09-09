package com.hy.ly.service.impl;

public class TeacherServiceBean {

	private String user = null;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public TeacherServiceBean() {
	}

	public TeacherServiceBean(String user) {
		this.user = user;
	}

	public void add(String name) {
		System.out.println("我是add()方法");
	}

	public void update(String name, Integer stuId) {
		System.out.println("我是update()方法");
	}

	public String getStudentName() {
		System.out.println("我是getStudentName()方法");
		return "TomCat";
	}

}
