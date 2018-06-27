package com.ming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ming.beans.Book;
import com.ming.beans.BookType;

@Repository
public class BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	//按类别查询
	public List<Book> selectByTypeId(int id){
		Session session = sessionFactory.getCurrentSession();
		List<Book> list=new ArrayList<Book>();
		BookType type=new BookType();
		type.setId(id);
		String sql="select u from Book u where u.type=?";
		Query query=session.createQuery(sql);
		query.setParameter(0, type);
		list=query.list();
//		trans.commit();
//		session.close();
		return list;	
	}
	//按book_stater热门商品，普通商品，最新商品查询
	public List<Book> selectBybookstate(String book_state){
		Session session = sessionFactory.getCurrentSession();
		List<Book>list=new ArrayList<Book>();
		String sql="select u from 	Book u  where u.book_state=?";
		Query query =session.createQuery(sql);
		query.setParameter(0, book_state);
		list=query.list();
		return list;
	}
	//查询某个商品Byid
	public Book selectById(int id){
		System.out.println("dao");
		Book book=new Book();
		Session session = sessionFactory.getCurrentSession();
		String sql="select u from Book u where u.id=?";
		Query query=session.createQuery(sql);
		query.setParameter(0, id);
		book=(Book) query.uniqueResult();
//		trans.commit();
//		session.close();
		return book;
		
	}
	//查看所有商品列表
	public List<Book> selectAll(){
		Session session = sessionFactory.getCurrentSession();
		List<Book> list=new ArrayList<Book>();
		String sql="from Book ";
		Query query=session.createQuery(sql);
		list=query.list();
//		trans.commit();
//		session.close();
		return list;	
	}
	//添加、修改、删除、查询商品
	public boolean insert(Book book) {
		System.out.println("insert");
		Session session = sessionFactory.getCurrentSession();	
		session.save(book);
		return true;
	}
	public boolean update(Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book book1=session.load(Book.class,new Integer(book.getId()));
		book1.setBook_description(book.getBook_description());
		book1.setBook_imgurl(book.getBook_imgurl());
		book1.setBook_name(book.getBook_name());
		book1.setBook_price(book.getBook_price());
		book1.setType(book.getType());
		book1.setOrder_detail(book.getOrder_detail());
		return true;
		
	}
	public boolean delete(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(book);
		return true;
	}
	

}

