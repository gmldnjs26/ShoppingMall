package com.spring.kwak.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kwak.dto.CartVO;
import com.spring.kwak.service.CartService;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO cartDAO;
	@Override
	public void deleteCart(CartVO vo) {
		cartDAO.deleteCart(vo);
	}

	@Override
	public List<CartVO> getListCart(String id) {
		return cartDAO.getListCart(id);
	}

	@Override
	public void insertCart(CartVO vo) {
		cartDAO.insertCart(vo);
	}

}
