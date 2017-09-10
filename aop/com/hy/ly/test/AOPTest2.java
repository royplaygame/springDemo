package com.hy.ly.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.service.CustomerSerivce;

public class AOPTest2 {

	@Test
	public void test(){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("aopBean.xml");
		CustomerSerivce customer=(CustomerSerivce) ctx.getBean("customerService");
		customer.add("Tomcat");
		customer.getStudentName();
		//customer.update("good", 1001);
		//customer.getStudentName();
		ctx.close();
	}
}
