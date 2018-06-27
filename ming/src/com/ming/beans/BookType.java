package com.ming.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BookType  implements Serializable {
	private int id;
	private  String type_name;
	private Set<Book> books=new HashSet<Book>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
