package com.ming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ming.beans.Admin;
import com.ming.beans.User;

@Repository
public class AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void insert(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.save(admin);
	}
	public boolean selectByname(String  user_username,String user_passwd) {
		boolean flag=false;
		
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("select u from Admin u where( u.admin_username=? or u.admin_email=?) and u.admin_passwd=?");
		query.setParameter(0, user_username).setParameter(1, user_username).setParameter(2,user_passwd);
		Admin user=(Admin)query.uniqueResult();
		if(user!=null) {
			flag=true;
		}
		return flag;
	}
	public List<Admin>viewadmin(){
		Session session=sessionFactory.getCurrentSession();
		 String sql=" from Admin";
			Query query =session.createQuery(sql);
			return query.list();
	}
	public void deleteadmin(int id) {
		 Session session=sessionFactory.getCurrentSession();
		 String sql="delete from Admin u where u.id=? ";
		 Query query =session.createQuery(sql).setParameter(0, id);
		 query.executeUpdate();
	}

}
