package com.ming.dao;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.ming.beans.User;


@Repository
public class OrderDao {
	@Autowired
	private SessionFactory sessionFactory;
//查询订单
	public List<Order> viewOrder(User user){
		Session session=sessionFactory.getCurrentSession();
		List<Order>list=new ArrayList<Order>();
		String sql="from Order o where o.user=?";
		Query query=session.createQuery(sql);
		query.setParameter(0,user);
		list=query.list();
		return list;
	}
	//取消单个订单从数据库中
//	public boolean quxiao(Set<Order>orders,User user,int id) {
//		System.out.println("daoe");
//		Session session=sessionFactory.getCurrentSession();
//		user.setOrders(orders);
//		session.delete(selectByid(id));
//		System.out.println(user.getOrders().size());
//		return true;
//	}
	//取消更改订单状态
	public boolean quxiao(Set<Order>orders,User user,int id) {
		System.out.println("daoe");
		Session session=sessionFactory.getCurrentSession();
		user.setOrders(orders);
		Query query=session.createQuery("update Order o set o.order_state=? where o.id=?").setParameter(0,"已取消").setParameter(1,id);
		int a=query.executeUpdate();
		if(a>0) {
			return true;
		}else{
			return false;
		}
		
	}
	//确认订单
	public void queren(int id) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("进入 dao");
//		for(Integer id:ids) {
//			Order order=session.get(Order.class, id);
//			order.setOrder_state("已确定");
//			
//		}
		String hql = "select u.orders from User u where u.id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        List<Order> os= query.list();
        System.out.println(os);
        Iterator<Order> ors1 = os.iterator();
        while(ors1.hasNext()){
        	 Order integer = ors1.next();
             if(integer.getOrder_state().equals("未处理")) {
            	 integer.setOrder_state("已确认");
                session.update(integer); //注意
             }
        }
        
		System.out.println("确认 dao");
	}
	//删除全部订单
	public boolean delete(User user) {
		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("全删");
		System.out.println(user);

		String hql = "select u.orders from User u where u.id=?";
	        Query query = session.createQuery(hql);
	        query.setParameter(0, user.getId());
	        List<Order> os = (List<Order>) query.list();
	        System.out.println(os);
	        Iterator<Order> ors1 = os.iterator();
	        while(ors1.hasNext()){
	        	System.out.println("全删");
	            session.delete(ors1.next());
	        }		
		
		return true;
	}
//	public boolean delete(Order order) {
//		boolean flag=false;
//		Session session=sessionFactory.getCurrentSession();
//		session.delete(order);
//		return flag;
//	}
	//修改订单
	public boolean update(Order order) {
		boolean flag=false;
		Session session=sessionFactory.getCurrentSession();
		Order orderr=session.get(Order.class,new Integer(order.getId()));
		//orderr.set
		return flag;
	}
	//生成订单
	public boolean createOrder(User user,String[]ids,String[]counts) {
		Session session=sessionFactory.getCurrentSession();	
		Order order=new Order();
		order.setUser(user);
		order.setOrder_state("未处理");
		System.out.println("用户名"+user);
		
			for(int i=0;i<ids.length;i++) {
				OrderDetail orderdetail=new OrderDetail();
				Book book=new Book();
				book.setId(Integer.parseInt(ids[i]));
				orderdetail.setBook(book);
				orderdetail.setCount(Integer.parseInt(counts[i]));	
				order.getOrder_detail().add(orderdetail);
				orderdetail.setOrders(order);		
			}
			
		user.getOrders().add(order);
		session.save(order);
	//	System.out.println(user.getOrders().isEmpty());
		return true;
	}
//	public Set getOrder_detail(Order order) {
//		return order.getOrder_detail();
//	}
	//根据orderid 查询order
	public Order selectByid(int id) {
		Session session=sessionFactory.getCurrentSession();
		Order order=session.get(Order.class,id);
		return order;
		
	}
	//根据order中的user查询order
//	public List<Integer> selectByuser(User user){
//		List<Integer>orders=new ArrayList<Integer>();
//		Session session=sessionFactory.getCurrentSession();
//		String sql="select o.id from Order o where o.user=?";
//		Query query =session.createQuery(sql).setParameter(0,user);
//		orders=query.list();
//		return orders;
//	}
	//查询所有订单后台
	public List<Order>selectall(){
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Order").list();
	}
	//后台删除某个订单
	public void deleteById(int id) {
		System.out.println("结束");
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Order o where o.id=?").setParameter(0, id);
		query.executeUpdate();	
	}
	//后台发货
	public void fahuo(int id) {
		Session session=sessionFactory.getCurrentSession();
		Order order=session.get(Order.class, new Integer(id));
		order.setOrder_state("已发货");
		
	}
}
