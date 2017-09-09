package com.hy.ly.test;

import org.junit.Test;

import com.hy.ly.aop.CGlibProxyFactory;
import com.hy.ly.service.impl.TeacherServiceBean;

public class AOPTest1 {

	/**
	 * 1.拦截所有的业务方法 
	 * 2.判断用户是否有权限，有权限就允许他执行业务方法，没有权限不允许他们执行业务方法。
	 * （是否有权限根据：user的值是否为空来判断）
	 */

	@Test
	public void test() {
		CGlibProxyFactory factory = new CGlibProxyFactory();
		TeacherServiceBean service = (TeacherServiceBean) factory.createProxyInstance(new TeacherServiceBean("TomCat"));
		service.add("book");
		service.getStudentName();
	}

	@Test
	public void test1() {
		CGlibProxyFactory factory = new CGlibProxyFactory();
		TeacherServiceBean service = (TeacherServiceBean) factory.createProxyInstance(new TeacherServiceBean());
		service.add("book");
		service.getStudentName();
	}

}
