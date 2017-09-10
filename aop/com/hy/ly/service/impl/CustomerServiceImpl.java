package com.hy.ly.service.impl;

import com.hy.ly.service.CustomerSerivce;

public class CustomerServiceImpl implements CustomerSerivce {

	@Override
	public void add(String name) {
		throw new RuntimeException("new Exception");
		//System.out.println("这是add()方法");
	}

	@Override
	public void update(String name, Integer stuId) {
		System.out.println("这是update()方法");
	}

	@Override
	public String getStudentName() {
		System.out.println("这是getStudentName()方法");
		return "Tomcat";
	}

}
