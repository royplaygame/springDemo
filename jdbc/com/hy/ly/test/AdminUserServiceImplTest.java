package com.hy.ly.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.po.AdminUser;
import com.hy.ly.service.AdminUserService;

public class AdminUserServiceImplTest {
	private static AdminUserService adminUserService;
	private static AbstractApplicationContext ctx = null;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("jdbcBean.xml");
		adminUserService = (AdminUserService) ctx.getBean("adminUserService");
	}

	@AfterClass
	public static void afterClasss() {
		ctx.close();
	}

	@Test
	public void testSetDataSource() {

	}

	@Test
	public void testAdd() {
		AdminUser admin = new AdminUser(1001, "liubei", "123456");
		adminUserService.add(admin);
	}

	@Test
	public void testUpdate() {
		AdminUser admin = new AdminUser(1002, "caocao", "123456");
		adminUserService.update(admin);
	}

	@Test
	public void testDelete() {
		adminUserService.delete(1021);
	}

	@Test
	public void testGetAdminUser() {
		AdminUser admin = adminUserService.getAdminUser(1003);
		System.out.println(admin);
	}

	@Test
	public void testGetList() {
		List<AdminUser> list = adminUserService.getList();
		for(AdminUser a:list){
			System.out.println(a);
		}
	}

}
