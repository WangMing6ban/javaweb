package com.ming.dao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ming.beans.Address;
import com.ming.beans.Order;
import com.ming.beans.User;
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	//admin查看用户列表
	//注册时根据用户名验证是否存在
	public int selectByUsername(String username) {
		int flag = 0;
		List<User>list=new ArrayList<User>();
		String sql="select u from User u where u.user_username=?0";
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery(sql);
		query.setParameter(0, username);
	    list=query.list();
	    //不可以用list!=null判断，因为会返回一条记录，就是什么都是null的记录
//	    if(list!=null) {
//	    	for(User user:list) {
//	    		System.out.println(user.getUser_username());
//	    	}
//	    	flag=1;
//	    }
		if(list.size()>0) {
			flag=1;
		}
		return flag;
	}
	//用户名和邮箱进行登录
	public boolean selectBynaem(String user_username,String user_passwd) {
		boolean flag=false;
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("select u from User u where( u.user_username=? or u.user_email=?) and u.user_passwd=?");
		query.setParameter(0, user_username).setParameter(1, user_username).setParameter(2,user_passwd);
		User user=(User)query.uniqueResult();
		if(user!=null) {
			flag=true;
		}
		return flag;
	}
	//根据session中的用户名和邮箱查询用户
	public User selectByname(String user_username) {
		System.out.println(user_username);
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("select u from User u where( u.user_username=? or u.user_email=?)");
		query.setParameter(0, user_username).setParameter(1, user_username);
		User user=(User)query.uniqueResult();
		return user;
	}
	//插入用户
	public void insert(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}
	//删除用户中的所有订单
	 public boolean deleteOrders(int  user_id){
		 Session session = sessionFactory.getCurrentSession();
		 session.get(User.class,user_id).setOrders(null);
		 return true;
		
	}
	 //添加用户的详细信息
	public void  xiangxi(String textarea,int id) {
		System.out.println("详细dao");
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, new Integer(id));
		user.setUser_detail(textarea);	
		session.save(user);
	}
    //修改密码 
	public boolean  xiugaipass(String repassword,int id) {
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, new Integer(id));
		user.setUser_passwd(repassword);
		return true;
	}
	//后台查用户
	public User selectByNaps(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("select u from User u where u.id=? ");
		query.setParameter(0, id);
		User user=(User)query.uniqueResult();
		return user;
		
	}
	//添加收货地址
	public Set<Address> addaddress(Address addresss,int id) {
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, new Integer(id));
		user.getAddress().add(addresss);
		addresss.setUser(user);
		System.out.println("地址"+addresss.getAddress());
		session.save(user);
		return (Set<Address>) user.getAddress();
	}
	//删除收货地址
	public void  deletadd(int id) {
		Session session=sessionFactory.getCurrentSession();
		Address address=session.get(Address.class, new Integer(id));
		session.delete(address);
	}
	//修改收货地址
	public void updatadd(String tele,String telee) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update  Address u set u.address=? where u.address =?");
		query.setParameter(0, telee).setParameter(1, tele);
		query.executeUpdate();
	
		
	}
	//查询地址
	public Set<Address> seleaddress(int id){
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, new Integer(id));
		return (Set<Address>) user.getAddress();
	}
	//查询用户
	 public List<User>viewuser(){
		 Session session=sessionFactory.getCurrentSession();
		 String sql=" from User";
		Query query =session.createQuery(sql);
		return query.list();
	 }
	 //删除用户
	 public void deleteuser(int id) {
		 Session session=sessionFactory.getCurrentSession();
		 String sql="delete from User u where u.id=? ";
		 Query query =session.createQuery(sql).setParameter(0, id);
		 query.executeUpdate();
		 
	 }
}
