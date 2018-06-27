package com.ming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ming.beans.BookType;
import com.ming.dao.TypeDao;

@Service
public class BookTypeService {
	@Autowired
	private TypeDao typedao;
	//查询所有商品类别
	@Transactional
	public List<BookType> typeall(){
		return typedao.typeall();
		
	}
	//查询类别by名称
	@Transactional
	public BookType selectByNa(String name) {
		return  typedao.selectByNa(name);
	}
	//添加商品类型
	@Transactional
	public void addclass(String name) {
		System.out.println("添加类别service");
		typedao.addclass(name);
	}
	@Transactional
	public void declass(int id) {
		typedao.declass(id);
	}
	
}
