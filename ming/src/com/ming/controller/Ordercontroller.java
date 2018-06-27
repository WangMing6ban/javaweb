package com.ming.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import com.ming.beans.Book;
import com.ming.beans.Order;
import com.ming.beans.OrderDetail;
import com.ming.beans.PageCount;
import com.ming.beans.User;
import com.ming.dao.UserDao;
import com.ming.services.BookService;
import com.ming.services.OrderDetailService;
import com.ming.services.OrderService;
import com.ming.services.UserService;

@Controller
public class Ordercontroller {
	@Autowired
	private OrderService orderservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private BookService bookservice;
	@Autowired
	private OrderDetailService orderdetailservice;
	@RequestMapping("/order")
	public String orderOperate(HttpServletRequest request,Model model) {
		String result=null;
		String action=request.getParameter("caozuo");
		if(action.equals("create")){
			result=createOrder(request);
		}else if(action.equals("view")) {	
			result=viewOrder(request);	
			return result;
		}else if(action.equals("quxiao")){
			result=quxiao(request,model);
		}else if(action.equals("delete")) {
			result=delete(request);
		}else if(action.equals("xiangqing")) {
			result=xiangqing(request,model);
		}else if(action.equals("listAll")){
			result=listAll(model,request);
		}else if(action.equals("deleteadmin")) {
			result=deleteadmin(request,model);
		}else if(action.equals("xiangqingadmin")) {
			result=xiangqingadmin(request,model);
		}else if(action.equals("queren")) {
			result=queren(request,model);
		}else if(action.equals("querendizhi")) {
			result=querendizhi(request);
		}else if(action.equals("fahuo")) {
			result=fahuo(request,model);
		}else if(action.equals("sousuo")) {
			System.out.println("搜索1");
			result=sousuo(request);
		}else if(action.equals("ss")) {
			result=ss(request,model);
		}
		return result;
	}
	//创建订单
	public String createOrder(HttpServletRequest request) {
		HttpSession session =request.getSession();
		String user_username=(String) session.getAttribute("user_username");
		System.out.println(user_username);
		User user=new User();
	    user=userservice.selectByName(user_username);
		String[] ids=request.getParameterValues("productid");
		String[] counts=request.getParameterValues("count") ;
		if(user!=null) {
		if(ids!=null&&counts!=null) {
			orderservice.createOrder(user,ids,counts);
			//生成订单后要清空购物车
			CartController cartcontroller =new CartController();
			cartcontroller.clearProductCart(request);
			return viewOrder(request);
		}else {
			return "user/index";
		}
		}
		return "user/login";
		
	}
	//查询订单
	public  String viewOrder(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String user_username=(String) session.getAttribute("user_username");
		System.out.println(user_username);
		User user=userservice.selectByName(user_username);
		System.out.println(user);
		List<Order>orders=new ArrayList<Order>();
		orders=orderservice.viewOrder(user);
		session.setAttribute("orders", orders);
		
		return "user/order";
	}
	//前台从数据库中取消订单
//	public String quxiao(HttpServletRequest request) {
//		HttpSession session=request.getSession();
//		String user_username=(String) session.getAttribute("user_username");
//		User user=userservice.selectByName(user_username);
//		Set<Order>orders= user.getOrders();//用户的订单user
//		int id=Integer.parseInt(request.getParameter("order_id"));
//		if(orders!=null) {
//			orderservice.quxiao(id,orders,user);
//		}
//		List<Order>orderr=(List<Order>) session.getAttribute("orders");
//		Iterator<Order> iterator = orderr.iterator();
//        while(iterator.hasNext()){
//            Order integer = iterator.next();
//            if(integer.getId()==id)
//                iterator.remove();   //注意这个地方
//        }
//        session.setAttribute("orders",orderr);
//		return viewOrder(request);
//	}
	//前台更改状态取消订单
	public String quxiao(HttpServletRequest request,Model model) {
	
		HttpSession session=request.getSession();
		String user_username=(String) session.getAttribute("user_username");
		User user=userservice.selectByName(user_username);
		Set<Order>orders= user.getOrders();
		int id=Integer.parseInt(request.getParameter("order_id"));
		if(orders!=null) {
			orderservice.quxiao(id,orders,user);
		}
		List<Order>orderr=(List<Order>) session.getAttribute("orders");
		System.out.println(orderr.size());
		Iterator<Order> iterator = orderr.iterator();
        while(iterator.hasNext()){
            Order integer = iterator.next();
            if(integer.getId()==id)
                iterator.remove();   //注意这个地方
        }
    	System.out.println(orderr.size());
        session.setAttribute("orders",orderr);
        return "user/order";
        
	}
	//前台从数据库中删除全部订单
	public String delete(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String user_username=(String) session.getAttribute("user_username");
		User user=userservice.selectByName(user_username);
		//userservice.deleteOrders(user.getId());注意这里
		orderservice.deleteByuser(user);
		return viewOrder(request);
	}
	//从前台确认地址
	
	public String  querendizhi(HttpServletRequest request) {
		String dizhi=request.getParameter("dizhi");
		HttpSession session=request.getSession();
		session.setAttribute("addresss", dizhi);
		viewOrder(request);
		return "user/order";
		
	}
	//从前台确认订单
	public String queren(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String address=request.getParameter("address");
		System.out.println("上边");
		System.out.println("确认地址"+address);
		if(address!=null) {
			session.setAttribute("quezhi", address);
		//	Set<Order>order=(Set<Order>)session.getAttribute("orders");
//			List<Integer>ids=null;
//			for(Order orders:order) {
//				System.out.println("地址");
//				ids.add(orders.getId());
//			}
			String user_username=(String) session.getAttribute("user_username");
			User user=userservice.selectByName(user_username);
			orderservice.queren(user.getId());
			
		}
		return "user/index";
	}
	//查看订单的详细信息
//	public String xiangqing(HttpServletRequest request) {
//		HttpSession session=request.getSession();
//		int id=Integer.parseInt(request.getParameter("order_id"));
//		List<OrderDetail> orderdetail=orderdetailservice.selectByorid(id);
//		session.setAttribute("oddetail",orderdetail);
//		return "user/orderdetail";
//	}
	//查看订单的详细信息
	public String xiangqing(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("order_id"));
		Order order=orderservice.selectByid(id);
		Set<OrderDetail>detailss= order.getOrder_detail();
		System.out.println("陈宫");
		Object[] details=detailss.toArray();
		System.out.println("陈宫了");
	    model.addAttribute("orderid",id);
		session.setAttribute("detail",details);
		return "user/orderdetail";
	}
	//从后台查看订单详情
	public String  xiangqingadmin(HttpServletRequest request, Model model){
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		Order order=orderservice.selectByid(id);
		Set<OrderDetail>detailss= order.getOrder_detail();
		Object[] details=detailss.toArray();
		 model.addAttribute("order",order);
		 session.setAttribute("det", detailss);
		 System.out.println(detailss);
		 int sum=0;
		 for(Object de:details) {
			 
			 sum+=((OrderDetail) de).gettolto();
			 System.out.println(detailss);
		 }
		 model.addAttribute("sum",sum);
		return "admin/admin_orderDetail";
	}
	//后台查询全部订单
	public  String listAll(Model model,HttpServletRequest  request) {
		List<Order> productList =orderservice.selectall();
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
		model.addAttribute("order",subList.isEmpty() ? null : subList);
		return "admin/admin_OrderList";
	}
	//从后台删除某个订单
	public String deleteadmin(HttpServletRequest  request,Model model) {
		System.out.println("开始");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		orderservice.deleteById(id);
		listAll(model,request);
		return "admin/admin_OrderList";
		
	}
	//后台进行发货处理
	public String fahuo(HttpServletRequest  request,Model model) {
		System.out.println("发货");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		List<Order> order =orderservice.selectall();
		model.addAttribute("order",order);
		orderservice.fahuo(id);
		listAll(model,request);
		return "admin/admin_OrderList";
	}
	//后台搜索订单
	public String sousuo(HttpServletRequest  request) {
		System.out.println("搜索");
		return "admin/admin_sousuo";
	}
	public String ss(HttpServletRequest  request,Model model) {
		String username=request.getParameter("name");
		User user=userservice.selectByName(username);
		System.out.println(user);
		List<Order>orders=new ArrayList<Order>();
		orders=orderservice.viewOrder(user);
		model.addAttribute("order",orders);
		return "admin/admin_OrderList";		
	}
	//
}
