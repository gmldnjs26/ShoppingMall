package com.spring.kwak.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kwak.dto.CartVO;

@Repository(value="cartDAO")
public class CartDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<CartVO>getListCart(String id){
		return mybatis.selectList("CartDAO.getListCart", id);
	}
	public void insertCart(CartVO vo) {
		mybatis.insert("CartDAO.insertCart", vo);
	}
	public void deleteCart(CartVO vo) {
		mybatis.delete("CartDAO.deleteCart",vo);
	}
}
