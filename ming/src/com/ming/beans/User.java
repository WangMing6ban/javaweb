package com.ming.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	private int id;
	private String user_username;
	private String user_passwd;
	private String user_email;
	private String user_imgurl;
	private String user_detail;
	private Set <Order>orders=new HashSet<Order>();
	private Set<Address>address=new HashSet<Address>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_imgurl() {
		return user_imgurl;
	}
	public void setUser_imgurl(String user_imgurl) {
		this.user_imgurl = user_imgurl;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public String getUser_detail() {
		return user_detail;
	}
	public void setUser_detail(String user_detail) {
		this.user_detail = user_detail;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	

}
