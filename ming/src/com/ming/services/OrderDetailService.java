package com.ming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ming.beans.OrderDetail;
import com.ming.dao.OrderDetailDao;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailDao orderdetaildao;
	//@Trancational
//	public List<OrderDetail>selectByorid(int id){
//		return orderdetaildao.selectByorid(id);
//	}
}
