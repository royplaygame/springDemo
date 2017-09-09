package com.hy.ly.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.dao.StudentDao;
import com.hy.ly.service.PersonService;

public class SpringTest {
	
	@Test
	public void test() {
		//ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
		//StudentService student=(StudentService) ctx.getBean("studentService");
		//StudentService student1=(StudentService) ctx.getBean("studentService");
		//System.out.println(student==student1);
		//student.save();
		
		//如果要关闭ApplicationContext，需要用到抽象类AbstractApplicationContext
		/*AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
		StudentService student=(StudentService) ctx.getBean("studentService7");
		student.save();
		ctx.close();*/
		
		//自动装配
		/*AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"myBeans.xml"});
		StudentService student=(StudentService) ctx.getBean("studentService");
		student.save();
		ctx.close();*/
		
		//自动扫包
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"autoBeans.xml"});
		PersonService student=(PersonService) ctx.getBean("studentService");
		StudentDao studentDao=(StudentDao) ctx.getBean("studentDaoBean");
		System.out.println(student);
		System.out.println(studentDao);
		//student.save();
		ctx.close();
	}

}
