package com.ming.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ming.beans.User;
import com.ming.services.UserService;

@Controller

public class LoginController {
	@Autowired
	private UserService userservice;
	@RequestMapping("/login")
	public String userlogin(HttpSession session,String user_username,String user_passwd) {
	
		if(user_username==null || user_passwd==null) {
			
		}else{
			boolean flag=false;
			flag=userservice.login(user_username,user_passwd);
			if(flag) {
				session.setAttribute("user_username",user_username);
				session.setAttribute("password", user_passwd);
				return "user/index";
			}
		}
		return "user/login";
	}

}
