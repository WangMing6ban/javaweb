package com.ming.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ming.beans.Order;
import com.ming.beans.User;
import com.ming.dao.OrderDao;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderdao;
	@Transactional
	//创建订单
	public boolean createOrder(User user,String[]ids,String[]counts) {
		orderdao.createOrder(user,ids,counts);
		return true;
	}
	@Transactional
	//查看个人订单
	public List<Order> viewOrder(User user){
		List<Order>orders=new ArrayList<Order>();
		orders=orderdao.viewOrder(user);
		return orders;
	}
	//@Transactional
	//取消单个订单从数据库中删除
//	public boolean quxiao(int id,Set<Order>orders,User user) {
//		System.out.println("service");
//		Iterator<Order> iterator = orders.iterator();
//        while(iterator.hasNext()){
//            Order integer = iterator.next();
//            if(integer.getId()==id)
//                iterator.remove();   //注意这个地方
//        }
//		System.out.println("service");
//		orderdao.quxiao(orders,user,id);
//		return true;
//	}
	//更改状态来取消订单
	@Transactional
	public boolean quxiao(int id,Set<Order>orders,User user) {
		System.out.println("service");
//		Iterator<Order> iterator = orders.iterator();
//        while(iterator.hasNext()){
//            Order integer = iterator.next();
//            if(integer.getId()==id)
//                iterator.remove();   //注意这个地方
//        }
		System.out.println("service");
		orderdao.quxiao(orders,user,id);
		return true;
	}
	@Transactional
	//用户确认订单
	public void queren(int id) {
		System.out.println("确认 sservice");
		orderdao.queren(id);
	}
	@Transactional
	//删除用户的全部的订单
	public void deleteByuser(User user) {
		orderdao.delete(user);
	}
	//根据orderid 查订单
	@Transactional
	public Order selectByid(int id) {
		return orderdao.selectByid( id);
	}
	//查询全部订单
	@Transactional
	public List<Order>selectall() {
		return orderdao.selectall();
	}
	//后台删除某个订单deleteById(orderid)
	@Transactional
	public void deleteById(int id) {
		System.out.println("中间");
		orderdao.deleteById(id);
	}
	//后台进行发货
	@Transactional
	public void fahuo(int id) {
		orderdao.fahuo(id);
	}
	
}
