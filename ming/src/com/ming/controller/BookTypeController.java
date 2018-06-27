package com.ming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ming.beans.BookType;
import com.ming.services.BookService;
import com.ming.services.BookTypeService;

@Controller
public class BookTypeController {
	@Autowired
	private BookTypeService booktypeservice;
	@RequestMapping("/addclass")
	//添加商品类别
		public String addclass(String name,Model model) {
		System.out.println("类别名称"+name);
			booktypeservice.addclass(name);
			List<BookType> bookTypeList=booktypeservice.typeall();
			viewclass( model);
			return "admin/admin_ClassList";
		}
	//查看商品类别后台
	@RequestMapping("/viewclass")
	public String viewclass(Model model) {
		List<BookType> bookTypeList=booktypeservice.typeall();
		model.addAttribute("classlist",bookTypeList);
		return "admin/admin_ClassList";
	}
	//查看商品类别前台
	@RequestMapping("/ty")
	public String ty(Model model) {
		List<BookType> bookTypeList=booktypeservice.typeall();
		model.addAttribute("slist",bookTypeList);
		return "user/index";
	}
	//删除类别
	@RequestMapping("/declass")
	public String declass(Model model,HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		booktypeservice.declass(id);
		viewclass( model);
		return "admin/admin_ClassList";
	}

}
