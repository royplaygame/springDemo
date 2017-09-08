package com.hy.ly.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.service.StudentService;
import com.hy.ly.service.impl.StudentBean;

public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
		StudentService student=(StudentService) ctx.getBean("studentService");
		student.save();
	}

}
