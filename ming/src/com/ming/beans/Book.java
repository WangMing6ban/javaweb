package com.ming.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Book implements Serializable  {
	private int id;
	private String book_name;
	private Double book_price;
	private String book_description;
	private String book_imgurl;
	private BookType type;
	private String book_state;
	private Set<OrderDetail>order_detail=new HashSet<OrderDetail>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Double getBook_price() {
		return book_price;
	}
	public void setBook_price(Double book_price) {
		this.book_price = book_price;
	}
	public String getBook_description() {
		return book_description;
	}
	public void setBook_description(String book_desciption) {
		this.book_description = book_desciption;
	}
	public String getBook_imgurl() {
		return book_imgurl;
	}
	public void setBook_imgurl(String book_imgurl) {
		this.book_imgurl = book_imgurl;
	}
	public BookType getType() {
		return type;
	}
	public void setType(BookType type) {
		this.type = type;
	}
	public Set<OrderDetail> getOrder_detail() {
		return order_detail;
	}
	public void setOrder_detail(Set<OrderDetail> order_detail) {
		this.order_detail = order_detail;
	}
	public String getBook_state() {
		return book_state;
	}
	public void setBook_state(String book_state) {
		this.book_state = book_state;
	}
	
	

}
