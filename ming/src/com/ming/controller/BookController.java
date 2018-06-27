package com.ming.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ming.beans.Book;
import com.ming.beans.BookType;
import com.ming.beans.PageCount;
import com.ming.services.BookService;
import com.ming.services.BookTypeService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookTypeService typeService;
	//后台添加商品
	@RequestMapping("/add")
	public String addBook(HttpServletRequest request,Model model,@RequestParam MultipartFile file) throws IOException {
		String realPath=request.getServletContext().getRealPath("/uploading");
		System.out.println(realPath);	
		System.out.println("controller");
		String filename=file.getOriginalFilename();
		File filee=new File(realPath+"/"+filename);
		FileOutputStream out=new FileOutputStream(filee);
		out.write(file.getBytes());
		System.out.println(filename);
		List<BookType> bookTypeList=typeService.typeall();
		request.setAttribute("bookType", bookTypeList);
		Book book=new Book();
		String book_id = request.getParameter("id");
		String book_name = request.getParameter("product");
		String book_price = request.getParameter("price");
		String classid = request.getParameter("classid");
		String description = request.getParameter("description");
		book.setBook_name(book_name);
		book.setBook_price(Double.parseDouble(book_price));
		book.setBook_imgurl("/uploading"+"/"+filename);
		book.setBook_description(description);
		BookType bookType=typeService.selectByNa(classid);
		book.setType(bookType);
		 
		bookService.addService(book);
		viewBook(model,request);
		return "admin/admin_BookList";
	}
	@RequestMapping("/hotProduct")
	public String hotProduct(HttpServletRequest request,Model model) {
		List<Book>productList=new ArrayList<Book>();
		String book_state=request.getParameter("book_state");
		System.out.println(book_state);
		productList=bookService.selectBybookstate(book_state);
		int pageNum;
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr == null || pageNumStr.equals("")) {
			pageNumStr = "1";
		}
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
		if (pageNum < 1)
			pageNum = 1;
		PageCount pageCount = new PageCount();// 创建分页对象
		pageCount.setPageSize(5);
		pageCount.setRecordCount(productList.size());
		pageCount.setCount(pageCount.getRecordCount(), pageCount.getPageSize());
		pageCount.setShowPage(1);
		if (pageNum == 0 || pageNum < -1) {
			pageCount.setShowPage(1);
		} else if (pageNum == -1 || pageNum > pageCount.getCount()) {
			pageCount.setShowPage(pageCount.getCount());
		} else {
			pageCount.setShowPage(pageNum);
		}
		request.setAttribute("pageCount", pageCount);
		int showPage = pageCount.getShowPage();
		int pageSize = pageCount.getPageSize();

		int begin, end;
		if (showPage <= 1) {
			begin = 0;
		} else if (showPage > pageCount.getCount()) {
			begin = (pageCount.getCount() - 1) * pageSize;
		} else {
			begin = (showPage - 1) * pageSize;
		}
		if (showPage * pageSize > pageCount.getRecordCount()) {
			end = pageCount.getRecordCount();
		} else {
			end = showPage * pageSize;
		}
		List subList = new ArrayList();
		subList = productList.subList(begin, end);
		model.addAttribute("hotlist",subList.isEmpty() ? null : subList);
	//	String basePath =request.getServletContext().getContextPath();
		return "user/hotProduct";
	}
	
	@RequestMapping("/newProduct")
	public String newProduct(HttpServletRequest request,Model model) {
		List<Book>productList=new ArrayList<Book>();
		String book_state=request.getParameter("book_state");
		System.out.println(book_state);
		productList=bookService.selectBybookstate(book_state);
		int pageNum;
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr == null || pageNumStr.equals("")) {
			pageNumStr = "1";
		}
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
		if (pageNum < 1)
			pageNum = 1;
		PageCount pageCount = new PageCount();// 创建分页对象
		pageCount.setPageSize(5);
		pageCount.setRecordCount(productList.size());
		pageCount.setCount(pageCount.getRecordCount(), pageCount.getPageSize());
		pageCount.setShowPage(1);
		if (pageNum == 0 || pageNum < -1) {
			pageCount.setShowPage(1);
		} else if (pageNum == -1 || pageNum > pageCount.getCount()) {
			pageCount.setShowPage(pageCount.getCount());
		} else {
			pageCount.setShowPage(pageNum);
		}
		request.setAttribute("pageCount", pageCount);
		int showPage = pageCount.getShowPage();
		int pageSize = pageCount.getPageSize();

		int begin, end;
		if (showPage <= 1) {
			begin = 0;
		} else if (showPage > pageCount.getCount()) {
			begin = (pageCount.getCount() - 1) * pageSize;
		} else {
			begin = (showPage - 1) * pageSize;
		}
		if (showPage * pageSize > pageCount.getRecordCount()) {
			end = pageCount.getRecordCount();
		} else {
			end = showPage * pageSize;
		}
		List subList = new ArrayList();
		subList = productList.subList(begin, end);
		model.addAttribute("newlist",subList.isEmpty() ? null : subList);
	//	String basePath =request.getServletContext().getContextPath();
		return "user/newProduct";
	}
	//查询商品按商品类别
	@RequestMapping("/type")
	public String typeProduct(HttpServletRequest request,Model model) {
		List<Book>productList=new ArrayList<Book>();
		String idd=request.getParameter("type_id");
		int id=Integer.parseInt(idd);
		productList=bookService.selectByType(id);
		int pageNum;
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr == null || pageNumStr.equals("")) {
			pageNumStr = "1";
		}
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
		if (pageNum < 1)
			pageNum = 1;
		PageCount pageCount = new PageCount();// 创建分页对象
		pageCount.setPageSize(5);
		pageCount.setRecordCount(productList.size());
		pageCount.setCount(pageCount.getRecordCount(), pageCount.getPageSize());
		pageCount.setShowPage(1);
		if (pageNum == 0 || pageNum < -1) {
			pageCount.setShowPage(1);
		} else if (pageNum == -1 || pageNum > pageCount.getCount()) {
			pageCount.setShowPage(pageCount.getCount());
		} else {
			pageCount.setShowPage(pageNum);
		}
		request.setAttribute("pageCount", pageCount);
		int showPage = pageCount.getShowPage();
		int pageSize = pageCount.getPageSize();

		int begin, end;
		if (showPage <= 1) {
			begin = 0;
		} else if (showPage > pageCount.getCount()) {
			begin = (pageCount.getCount() - 1) * pageSize;
		} else {
			begin = (showPage - 1) * pageSize;
		}
		if (showPage * pageSize > pageCount.getRecordCount()) {
			end = pageCount.getRecordCount();
		} else {
			end = showPage * pageSize;
		}
		List subList = new ArrayList();
		subList = productList.subList(begin, end);
		model.addAttribute("typelist",subList.isEmpty() ? null : subList);
		return "user/booktype";
	}
	//后台查看商品
	@RequestMapping("/book")
	public String viewBook(Model model,HttpServletRequest request){
		List<Book> productList =bookService.viewBook();
		int pageNum;
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr == null || pageNumStr.equals("")) {
			pageNumStr = "1";
		}
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
		if (pageNum < 1)
			pageNum = 1;
		PageCount pageCount = new PageCount();// 创建分页对象
		pageCount.setPageSize(5);
		pageCount.setRecordCount(productList.size());
		pageCount.setCount(pageCount.getRecordCount(), pageCount.getPageSize());
		pageCount.setShowPage(1);
		if (pageNum == 0 || pageNum < -1) {
			pageCount.setShowPage(1);
		} else if (pageNum == -1 || pageNum > pageCount.getCount()) {
			pageCount.setShowPage(pageCount.getCount());
		} else {
			pageCount.setShowPage(pageNum);
		}
		request.setAttribute("pageCount", pageCount);
		int showPage = pageCount.getShowPage();
		int pageSize = pageCount.getPageSize();

		int begin, end;
		if (showPage <= 1) {
			begin = 0;
		} else if (showPage > pageCount.getCount()) {
			begin = (pageCount.getCount() - 1) * pageSize;
		} else {
			begin = (showPage - 1) * pageSize;
		}
		if (showPage * pageSize > pageCount.getRecordCount()) {
			end = pageCount.getRecordCount();
		} else {
			end = showPage * pageSize;
		}
		List subList = new ArrayList();
		subList = productList.subList(begin, end);
		
		model.addAttribute("booklist",subList.isEmpty() ? null : subList);
		 return "admin/admin_BookList";
	}
	//前台查看商品
	@RequestMapping("/bookuser")
	public String kan(Model model,HttpServletRequest request){
		List<Book> productList =bookService.viewBook();
		int pageNum;
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr == null || pageNumStr.equals("")) {
			pageNumStr = "1";
		}
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
		if (pageNum < 1)
			pageNum = 1;
		PageCount pageCount = new PageCount();// 创建分页对象
		pageCount.setPageSize(2);
		pageCount.setRecordCount(productList.size());
		pageCount.setCount(pageCount.getRecordCount(), pageCount.getPageSize());
		pageCount.setShowPage(1);
		if (pageNum == 0 || pageNum < -1) {
			pageCount.setShowPage(1);
		} else if (pageNum == -1 || pageNum > pageCount.getCount()) {
			pageCount.setShowPage(pageCount.getCount());
		} else {
			pageCount.setShowPage(pageNum);
		}
		request.setAttribute("pageCount", pageCount);
		int showPage = pageCount.getShowPage();
		int pageSize = pageCount.getPageSize();

		int begin, end;
		if (showPage <= 1) {
			begin = 0;
		} else if (showPage > pageCount.getCount()) {
			begin = (pageCount.getCount() - 1) * pageSize;
		} else {
			begin = (showPage - 1) * pageSize;
		}
		if (showPage * pageSize > pageCount.getRecordCount()) {
			end = pageCount.getRecordCount();
		} else {
			end = showPage * pageSize;
		}
		List subList = new ArrayList();
		subList = productList.subList(begin, end);
		 model.addAttribute("booklist",subList.isEmpty() ? null : subList);
		 return "user/book";
	}
	//删除商品
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model){
	int id=	Integer.parseInt(request.getParameter("id")) ;
	System.out.println(id);
		Book book=bookService.selectById(id);
		bookService.delete(book);
		viewBook(model,request);
		 return "admin/admin_BookList";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model){
		int id=	Integer.parseInt(request.getParameter("id")) ;
		System.out.println(id);
		Book book = bookService.selectById(id);
		model.addAttribute("book",book);
		List<BookType> bookTypeList=typeService.typeall();
		request.setAttribute("bookType", bookTypeList);
		return "/admin/admin_updateBook";
	}
	//修改book
	@RequestMapping("/xiugai")
	public String xiugai(HttpServletRequest request,Model model){
		Book book = new Book();
		String book_id = request.getParameter("id");
		String book_name = request.getParameter("product");
		String book_price = request.getParameter("price");
		String classid = request.getParameter("classid");
		String description = request.getParameter("description");
		String book_imgurl = request.getParameter("book_imgurl");
		book.setId(Integer.parseInt(book_id));
		book.setBook_name(book_name);
		book.setBook_price(Double.parseDouble(book_price));
		book.setBook_imgurl(book_imgurl);
		book.setBook_description(description);
		BookType bookType = new BookType();
		bookType.setId(Integer.parseInt(classid));
		book.setType(bookType);
		bookService.update(book);
		System.out.println(book);
		viewBook(model,request);
		 return "admin/admin_BookList";
	}
	//添加商品
	@RequestMapping("/tianjia")
	public String tianjiatype(HttpServletRequest request) {
	List<BookType> bookTypeList=typeService.typeall();
	request.setAttribute("bookType", bookTypeList);
	return "admin/admin_addBook";
	}
	@RequestMapping("/liulan")
	public String liulan(HttpServletRequest request,Model model) {
		
		int id=	Integer.parseInt(request.getParameter("id")) ;
		Book book=bookService.selectById(id);
		System.out.println(book);
		model.addAttribute("book",book);
		return "user/subpage";
	}
	
	
}
