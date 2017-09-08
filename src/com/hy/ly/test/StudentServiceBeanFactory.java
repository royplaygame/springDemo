package com.hy.ly.test;

import com.hy.ly.service.impl.StudentServiceBean;

/**
 * 静态工厂方法
 * @author ssr
 *
 */
public class StudentServiceBeanFactory {

	public static StudentServiceBean createStudentServiceBean(){
		return new StudentServiceBean();
	}
	
	public StudentServiceBean createStudentServiceBean2(){
		return new StudentServiceBean();
	}
}
