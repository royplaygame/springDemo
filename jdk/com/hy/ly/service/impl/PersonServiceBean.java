package com.hy.ly.service.impl;

import com.hy.ly.service.PersonService;

public class PersonServiceBean implements PersonService {

	private String user = null;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public PersonServiceBean() {
	}

	public PersonServiceBean(String user) {
		this.user = user;
	}

	@Override
	public void add(String name) {
		System.out.println("我是add()方法");
	}

	@Override
	public void update(String name, Integer stuId) {
		System.out.println("我是update()方法");
	}

	@Override
	public String getStudentName() {
		System.out.println("我是getStudentName()方法");
		return "TomCat";
	}

}
