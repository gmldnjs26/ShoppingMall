package com.spring.kwak.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kwak.dto.AdminVO;
import com.spring.kwak.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public AdminVO aLogin(AdminVO vo) {
		return adminDAO.aLogin(vo);
	}
}
