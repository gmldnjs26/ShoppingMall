package com.spring.kwak.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kwak.dto.OrderVO;

@Repository(value="orderDAO")
public class OrderDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertOrder(OrderVO vo) {
		mybatis.insert("OrderDAO.insertOrder", vo);
	}
	
	public List<OrderVO> getListOrder(String id) {
		return mybatis.selectList("OrderDAO.getListOrder", id);
	}
	
	public List<OrderVO>getAllListOrder(String id){
		return mybatis.selectList("OrderDAO.getAllListOrder",id);
	}
} 
