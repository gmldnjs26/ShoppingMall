package com.spring.kwak.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kwak.dto.AdminVO;

@Repository("adminDAO")
public class AdminDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public AdminVO aLogin(AdminVO vo) {
		return mybatis.selectOne("AdminDAO.getAdmin", vo);
	}
}
