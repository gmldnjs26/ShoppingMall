package com.spring.kwak.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kwak.dto.OrderVO;
import com.spring.kwak.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public void insertOrder(OrderVO vo) {
		orderDAO.insertOrder(vo);
	}
	@Override
	public List<OrderVO> getOrderList(String id) {
		return orderDAO.getListOrder(id);
	}
	@Override
	public List<OrderVO> getAllListOrder(String id) {
		return orderDAO.getAllListOrder(id);
	}
	
}
