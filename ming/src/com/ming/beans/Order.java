package com.ming.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Order implements Serializable {
	private int id;
	private User user;
	private String order_state;
	private Set<OrderDetail>order_detail=new HashSet<OrderDetail>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public Set<OrderDetail> getOrder_detail() {
		return order_detail;
	}
	public void setOrder_detail(Set<OrderDetail> order_detail) {
		this.order_detail = order_detail;
	}
	
	

}
