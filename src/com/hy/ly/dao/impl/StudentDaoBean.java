package com.hy.ly.dao.impl;

import org.springframework.stereotype.Repository;

import com.hy.ly.dao.StudentDao;

@Repository
public class StudentDaoBean implements StudentDao{

	@Override
	public void add() {
		System.out.println("this is studentDaoBean add method");
	}

}
