package com.ming.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ming.beans.Address;
import com.ming.beans.User;
import com.ming.services.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserService userservice;
	@RequestMapping("/userdetail")
	public String  userdetail(HttpServletRequest request,Model model) {
		User user=userservice.selectByName((String)request.getSession().getAttribute("user_username"));
		model.addAttribute("yonghu",user);
		return "user/userdetail";
	}
	//添加详细信息
	@RequestMapping("/xiangxi")
	public String  xiangxi(HttpServletRequest request) throws UnsupportedEncodingException {
		HttpSession session=request.getSession();
		System.out.println("添加详细信息");
		String textarea=request.getParameter("textarea");
		System.out.println(textarea);
		User user=userservice.selectByName((String)request.getSession().getAttribute("user_username"));
		System.out.println(user);
		userservice.xiangxi(textarea,user.getId());
		session.setAttribute("user_detail",textarea );
		return "user/index";
	}
	//修改密码
	@RequestMapping("/password")
	public void yanzhengjiupass(HttpServletRequest request,HttpServletResponse response) {
		String password=request.getParameter("password");
		System.out.println("好美");
		String massage="";
		if(password.equals((String)request.getSession().getAttribute("password"))){
			System.out.println("tina");
			massage="{\"content\":\"密码正确\",\"flag\":true}";
			
		}else {
			massage="{\"content\":\"密码有误\",\"flag\":false}";
		}
		try {
			response.getWriter().write(massage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/repassword")
	public String repassword(String reuser_passwd,String user_passwd,HttpServletRequest request) {
		if(reuser_passwd!=null&& user_passwd!=null) {
			User user=userservice.selectByName((String)request.getSession().getAttribute("user_username"));
			boolean flag=userservice.xiugaipass(reuser_passwd,user.getId());
			return "user/repasswordsucess";

		}else {
			return "user/repassword";
		}
	}
	//添加收获地址
	@RequestMapping("/addaddress")
	public String addaddress(String address,String telephone,HttpServletRequest request,Model model) {
		System.out.println(address);
		Address addressss=new Address();
		addressss.setAddress(address);
		addressss.setTelephone(telephone);
		System.out.println("地址对象"+addressss);
		HttpSession session=request.getSession();
		User user=userservice.selectByName((String)request.getSession().getAttribute("user_username"));
		System.out.println("用户名"+user);
		Set<Address>addresss=userservice.addaddress(addressss,user.getId());
		model.addAttribute("addresss", addresss);
		
		
		
		return "user/address";
		
	}
	
	//修改收货地址
	@RequestMapping("updatadd")
	public String updatadd(HttpServletRequest request,Model model) {
		String tele=request.getParameter("tele");
		String telee=request.getParameter("telee");
		System.out.println(telee);
		userservice.updatadd(tele,telee);
		User user=userservice.selectByName((String)request.getSession().getAttribute("user_username"));
		System.out.println("用户名"+user);
		Set<Address>addresss=userservice.seleaddress(user.getId());
		model.addAttribute("addresss", addresss);
		return "user/address";
	}
	//删除收货地址
	@RequestMapping("/deletadd")
	public String deletadd(HttpServletRequest request,Model model) {
		int id=Integer.parseInt(request.getParameter("id"));
		userservice.deletadd(id);
		System.out.println(id);
		User user=userservice.selectByName((String)request.getSession().getAttribute("user_username"));
		System.out.println("用户名"+user);
		Set<Address>addresss=userservice.seleaddress(user.getId());
		model.addAttribute("addresss", addresss);
		return "user/address";
	}
	//查看用户信息
	@RequestMapping("/viewuser")
	public String viewuser(Model model) {
		List<User>userlist=userservice.viewuser();
		model.addAttribute("userlist",userlist);
		return "/user/userlist"; 
		
	}
	//删除用户
	@RequestMapping("/deleteuser")
	public String deleteuser(HttpServletRequest request,Model model) {
		int id=Integer.parseInt(request.getParameter("id"));
		userservice.deleteuser(id);
		viewuser( model);
		return "/user/userlist"; 
		
	}
	//后台修改用户
	@RequestMapping("/updateuser")
	public String updateuser(HttpServletRequest request,Model model) {
		int id=Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		return "admin/updateuserjsp";
		
	}
	@RequestMapping("/xiugaiuser")
	public String xiugaiuser(String reuser_passwd,String password,HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		if(reuser_passwd!=null&& password!=null) {
			User user=userservice.selectByNaps(id);
			
			boolean flag=userservice.xiugaipass(reuser_passwd,id);
			return "admin/repasswordsucess";

		}else {
			return "admin/updateuserjsp";
		}
	}
	//后台添加用户
	@RequestMapping("/ttju")
	public String ttju(HttpServletRequest request) {
		return "admin/ttju";
	}
	@RequestMapping("/tju")
	public String tju(HttpServletRequest request,HttpServletResponse response,String username,String juese,String password,String email,@RequestParam MultipartFile img) throws IOException {
		System.out.println("进入控制台");
	//	String juese=request.getParameter("juese");
		
		
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
		return "admin/tij";
	
	}
	
}
