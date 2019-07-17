package com.spring.kwak.service;

import java.util.List;

import com.spring.kwak.dto.CartVO;

public interface CartService {
	// 사용자 장바구니 가져오기
	public List<CartVO>getListCart(String id);
	
	// 상품 장바구니에 넣기
	public void insertCart(CartVO vo);
	
	// 상품 장바구니에서 삭제하기
	public void deleteCart(CartVO vo);
}
