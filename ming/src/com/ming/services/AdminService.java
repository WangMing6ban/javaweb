package com.ming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ming.beans.Admin;
import com.ming.dao.AdminDao;

@Service
public class AdminService {
	@Autowired
	private AdminDao admindao;
	//注册
	@Transactional
	public void insert(Admin admin) {
		admindao.insert(admin);
	}
	//验证登录
	@Transactional
	public boolean selectByname( String user_username,String user_passwd) {
		return admindao.selectByname(user_username,user_passwd);
	}
	//查看admin
	@Transactional
	public List<Admin>viewadmin(){
		return admindao.viewadmin();
	}
	@Transactional
	public void deleteadmin(int id) {
		admindao.deleteadmin(id);
	}
}
