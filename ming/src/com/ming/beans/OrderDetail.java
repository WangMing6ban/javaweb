package com.ming.beans;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	private int id;
	private int count;
	private Book book;
	private Order orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrders() {
		return orders;
	}
	public void setOrders(Order order) {
		this.orders = order;
	}
	
	public double gettolto() {
		
		return book.getBook_price()*count;
		
		
	}
}
