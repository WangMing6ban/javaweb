package com.ming.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ming.beans.Book;
import com.ming.dao.BookDao;

@Service

public class BookService {
	@Autowired
	private BookDao bookdao;
	@Transactional
	public void addService(Book book) {
		//逻辑处理
		System.out.println("service");
		bookdao.insert(book);
	}
	@Transactional
	public List<Book> selectBybookstate(String book_state){
		List<Book>list=new ArrayList<Book>();
		list=bookdao.selectBybookstate(book_state);
		return list;
	}
	@Transactional
	public List<Book>selectByType( int id){
		List<Book>list=new ArrayList<Book>();
		list=bookdao.selectByTypeId(id);
		return list;
	}
	@Transactional
	public Book selectById(int id) {
		//逻辑处理
		System.out.println("fuwu");
	Book book=bookdao.selectById(id);
	return book;
	}
	@Transactional
	public List<Book> viewBook(){
		return bookdao.selectAll();
	}
	@Transactional
	public void delete(Book book) {
		bookdao.delete(book);
	}
	@Transactional
	public void update(Book book) {
		bookdao.update(book);
	}
	
	
}
