package com.ming.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ming.beans.Book;
import com.ming.beans.Order;
import com.ming.beans.OrderDetail;

@Repository
public class OrderDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	public OrderDetail createorderDetail(Book book,int count,Order order) {
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setBook(book);
		return orderDetail;
	}
//	public List<OrderDetail>selectByorid(int id){
//		List<OrderDetail> orderdetail=new ArrayList<OrderDetail>();
//		Session session=sessionFactory.getCurrentSession();
//		Query query=session.createQuery("select u from order_detail u where u.order_id=?");
//		orderdetail=query.setParameter(0, id).list();
//		return orderdetail;
//	}
}
