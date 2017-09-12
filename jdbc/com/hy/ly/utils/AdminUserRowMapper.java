package com.hy.ly.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hy.ly.po.AdminUser;

public class AdminUserRowMapper implements RowMapper<AdminUser> {

	@Override
	public AdminUser mapRow(ResultSet rs, int adminNo) throws SQLException {
		AdminUser admin = new AdminUser();
		admin.setAdminNo(rs.getInt(1));
		admin.setAdminAcount(rs.getString(2));
		admin.setPassword(rs.getString(3));
		return admin;
	}

}
