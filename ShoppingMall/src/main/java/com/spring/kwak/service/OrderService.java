package com.spring.kwak.service;

import java.util.List;

import com.spring.kwak.dto.OrderVO;

public interface OrderService {
	public void insertOrder(OrderVO vo);
	
	public List<OrderVO>getOrderList(String id); // 진행중인 주문
	 
	public List<OrderVO>getAllListOrder(String id); // 모든 주문 리스트 
} 
