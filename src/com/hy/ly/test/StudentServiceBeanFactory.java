package com.hy.ly.test;

import com.hy.ly.service.impl.PersonServiceBean;

/**
 * 静态工厂方法
 * @author ssr
 *
 */
public class StudentServiceBeanFactory {

	public static PersonServiceBean createStudentServiceBean(){
		return new PersonServiceBean();
	}
	
	public PersonServiceBean createStudentServiceBean2(){
		return new PersonServiceBean();
	}
}
