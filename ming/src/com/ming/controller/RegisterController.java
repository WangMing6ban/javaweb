package com.ming.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ming.beans.Admin;
import com.ming.beans.User;
import com.ming.services.AdminService;
import com.ming.services.UserService;

@Controller
@ResponseBody
public class RegisterController {
	@Autowired
	private UserService userservice;
	@Autowired
	private AdminService adminservice;
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,HttpServletResponse response,String username,String juese,String password,String email,@RequestParam MultipartFile img) throws IOException {
		System.out.println("进入控制台");
	//	String juese=request.getParameter("juese");
		System.out.println("输出角色"+juese);
		if(juese.equals("user")) {
		//插入users表中
		System.out.println(username);	
		String realPath=request.getServletContext().getRealPath("/uploading");
		System.out.println(realPath);	
		User user=new User();
		user.setUser_username(username);
		user.setUser_passwd(password);
		user.setUser_email(email);
		String filename=img.getOriginalFilename();
		File file=new File(realPath+"/"+filename);
		FileOutputStream out=new FileOutputStream(file);
		out.write(img.getBytes());
		System.out.println(filename);
		user.setUser_imgurl("uploading"+"/"+filename);
		userservice.insert(user);
		//邮箱激活功能
				boolean b=wasteMail(email,response);
				System.out.println(b);	
				return "user/registsucess";
		}else {
			
			String realPath=request.getServletContext().getRealPath("/uploading");
				
			
			String filename=img.getOriginalFilename();
			File file=new File(realPath+"/"+filename);
			FileOutputStream out=new FileOutputStream(file);
			out.write(img.getBytes());
			System.out.println(filename);
			
			
			
			
			
			
			Admin admin=new Admin();
			admin.setAdmin_username(username);
			admin.setAdmin_passwd(password);
			admin.setAdmin_email(email);
			
		
			
			
			admin.setAdmin_imgurl(realPath+"/"+filename);
			adminservice.insert(admin);
		
		//邮箱激活功能
		boolean b=wasteMail(email,response);
		System.out.println(b);	
		return "admin/registsuce";
		}
	}
	//邮箱激活方法
	public boolean wasteMail(String email,HttpServletResponse response) {
		boolean flag=false;
		flag=userservice.sendMail(email,response);
		return flag;
		
	}
	@RequestMapping("/registerr")
	public void registerr(HttpServletRequest request,HttpServletResponse response) {
		String username=request.getParameter("username");
		response.setContentType("text/html;charset=utf-8");
		System.out.println(username);
		int a=userservice.selet(username);
		String massage="";
		if(a>0) {
			 massage="{\"content\":\"用户名已经存在\",\"flag\":true}";
			 
		}else {
			 massage="{\"content\":\"用户名可以使用\",\"flag\":false}";
			 
		}
		try {
			response.getWriter().write(massage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
