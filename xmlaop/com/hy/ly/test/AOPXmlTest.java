package com.hy.ly.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.service.AnimalService;

public class AOPXmlTest {

	@Test
	public void test() {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("xmlBean.xml");
		AnimalService animalService=(AnimalService) ctx.getBean("animalService");
		animalService.add("Tom");
		animalService.getStudentName();
		animalService.update("HanMM", 1001);
		ctx.close();
	}

}
