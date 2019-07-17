package com.spring.kwak.service;

import java.util.List;

import com.spring.kwak.dto.AddressVO;
import com.spring.kwak.dto.UserVO;

public interface UserService {
	// 로그인
	public UserVO login(UserVO vo);
	
	//회원 가입
	public void join(UserVO vo);
	
	//아이디 중복확인
	public UserVO idCheck(UserVO vo);
	
	public List<AddressVO> findZip(AddressVO vo);
}

