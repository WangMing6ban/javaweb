package com.ming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ming.beans.Admin;
import com.ming.services.AdminService;
import com.ming.services.UserService;
@Controller
public class AdminController {
	@Autowired
	private AdminService adminservice;
	@RequestMapping("/adminlogin")
	public String userlogin(HttpServletRequest request) {
		String user_username=request.getParameter("username");
		String user_passwd=request.getParameter("password");
		HttpSession session=request.getSession();
		if(user_username==null || user_passwd==null) {
			return "admin/admin_login";
		}else {
			if(adminservice.selectByname( user_username,user_passwd)) {
				session.setAttribute("user_username",user_username);
				 return "admin/admin_main";
			}else {
				return "admin/admin_login";
			}
		
		}
	}
	@RequestMapping("/viewadmin")
	public String viewadmin(Model model) {
		List<Admin>list=adminservice.viewadmin();
		model.addAttribute("adminlist",list);
		return "admin/adminlist";
	}
	@RequestMapping("/deleteadmin")
	public String deleteadmin(HttpServletRequest request,Model model) {
		int id=Integer.parseInt(request.getParameter("id"));
		adminservice.deleteadmin(id);
		 viewadmin(model);
		return "admin/adminlist";
	}
}
