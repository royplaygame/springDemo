package com.hy.ly.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hy.ly.po.AdminUser;
import com.hy.ly.service.AdminUserService;
import com.hy.ly.utils.AdminUserRowMapper;

//@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//如果在方法上没有标注事务，可以省略不写，默认是：(propagation=Propagation.REQUIRED)
	//@Transactional(propagation=Propagation.REQUIRED)
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
	
	//1. RuntionException默认回滚事务;
	//2. (rollbackFor=Exception.class)即使是checked异常也会回滚
	//@Transactional(rollbackFor=Exception.class)  //不回滚修改成回滚
	//@Transactional(noRollbackFor=RuntimeException.class)  //回滚修改成功回滚
	public void delete(Integer adminNo) throws Exception {
		String sql = "delete from  adminac  where adminnumber=?";
		jdbcTemplate.update(sql, new Object[] { adminNo }, new int[] { java.sql.Types.INTEGER });
		//throw new RuntimeException("Exception");
		
		//1.如果有事务，上面记录不会被删除，事务出现异常，进行了回滚
		//2.如果没有事务，上面的记录会被删除。
		String sql1 = "delete from  adminacqqq  where adminnumber=?";
		jdbcTemplate.update(sql1, new Object[] { 1003 }, new int[] { java.sql.Types.INTEGER });

	}

	//不开启事务配置(propagation=Propagation.NOT_SUPPORTED)
	//@Transactional(propagation=Propagation.NOT_SUPPORTED)
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

	//@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<AdminUser> getList() {
		String sql = " select * from adminac";
		List<AdminUser> list = jdbcTemplate.query(sql, new AdminUserRowMapper());
		return list;
	}

}
