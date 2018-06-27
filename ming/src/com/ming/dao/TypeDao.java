package com.ming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ming.beans.Book;
import com.ming.beans.BookType;

@Repository
public class TypeDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<BookType> typeall(){
		Session session = sessionFactory.getCurrentSession();
		List<BookType>list=new ArrayList<BookType>();
		String sql=" from BookType  ";
		Query query =session.createQuery(sql);
	
		list=query.list();
		return list;
	}
	public BookType  selectByNa(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("select u from BookType u where u.type_name=?");
		BookType type=(BookType) query.setParameter(0, name).uniqueResult();
		return type;
	}
	public void addclass(String name) {
		Session session = sessionFactory.getCurrentSession();
		BookType booktype=new BookType();
		booktype.setType_name(name);
		session.save(booktype);
	}
	public void declass(int id) {
		Session session=sessionFactory.getCurrentSession();
		 String sql="delete from BookType u where u.id=? ";
		 Query query =session.createQuery(sql).setParameter(0, id);
		 query.executeUpdate();
	}
}
