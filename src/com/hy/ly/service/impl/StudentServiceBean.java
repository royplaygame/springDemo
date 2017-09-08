package com.hy.ly.service.impl;

import com.hy.ly.service.StudentService;

public class StudentServiceBean implements StudentService {

	@Override
	public void save(){
		System.out.println("我是save()方法");
	}
}
