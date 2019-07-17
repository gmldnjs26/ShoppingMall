package com.spring.kwak.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kwak.dto.AddressVO;
import com.spring.kwak.dto.UserVO;

@Repository("userDAO")
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 회원가입 
	public void join(UserVO vo) {
		mybatis.insert("UserDAO.join", vo);
	}
	// 로그인
	public UserVO login(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	// 아이디 중복확인 
	public UserVO idCheck(UserVO vo) {
		return mybatis.selectOne("UserDAO.idCheck", vo);
	}
	public List<AddressVO> findZip(AddressVO vo){
		System.out.println("DAO : " + vo.getDong());
		return mybatis.selectList("UserDAO.findZip", vo);
	}
	
	
}
