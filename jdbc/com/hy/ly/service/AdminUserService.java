package com.hy.ly.service;

import java.util.List;

import com.hy.ly.po.AdminUser;

public interface AdminUserService {

	public void add(AdminUser admin);

	public void update(AdminUser admin);

	public void delete(Integer adminNo);

	public AdminUser getAdminUser(Integer adminNo);

	public List<AdminUser> getList();
}
