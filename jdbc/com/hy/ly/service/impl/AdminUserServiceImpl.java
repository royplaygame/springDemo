package com.hy.ly.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hy.ly.po.AdminUser;
import com.hy.ly.service.AdminUserService;
import com.hy.ly.utils.AdminUserRowMapper;

public class AdminUserServiceImpl implements AdminUserService {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void add(AdminUser admin) {
		String sql = "insert into adminac values(seq_admin.nextval,?,?)";
		jdbcTemplate.update(sql, new Object[] { admin.getAdminAcount(), admin.getPassword() },
				new int[] { java.sql.Types.VARCHAR, java.sql.Types.VARCHAR });
	}

	@Override
	public void update(AdminUser admin) {
		String sql = "update adminac set adminname=?,adminpwd=? where adminnumber=?";
		jdbcTemplate.update(sql, new Object[] { admin.getAdminAcount(), admin.getPassword(), admin.getAdminNo() },
				new int[] { java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.INTEGER });

	}

	@Override
	public void delete(Integer adminNo) {
		String sql = "delete from  adminac  where adminnumber=?";
		jdbcTemplate.update(sql, new Object[] { adminNo }, new int[] { java.sql.Types.INTEGER });

	}

	@Override
	public AdminUser getAdminUser(Integer adminNo) {
		String sql = " select * from adminac where adminnumber=?";
		List<AdminUser> list = jdbcTemplate.query(sql, new Object[] { adminNo }, new int[] { java.sql.Types.INTEGER },
				new AdminUserRowMapper());
		if (list.size() >= 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<AdminUser> getList() {
		String sql = " select * from adminac";
		List<AdminUser> list = jdbcTemplate.query(sql, new AdminUserRowMapper());
		return list;
	}

}
