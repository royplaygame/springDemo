package com.hy.ly.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBUtils {

	public static void main(String[] args) throws SQLException {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("jdbcBean.xml");
		BasicDataSource dataSource = (BasicDataSource) ctx.getBean("dataSource");
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		ctx.close();
	}

	
}
