package com.hy.ly.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.service.StudentService;

public class SpringTest {
	
	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
		StudentService student=(StudentService) ctx.getBean("studentService3");
		student.save();
	}

}
