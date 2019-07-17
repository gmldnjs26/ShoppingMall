package com.spring.kwak.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kwak.dto.AddressVO;
import com.spring.kwak.dto.UserVO;
import com.spring.kwak.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO login(UserVO vo) {
		return userDAO.login(vo);
	}

	@Override
	public void join(UserVO vo) {
		userDAO.join(vo);
	}
	@Override
	public UserVO idCheck(UserVO vo) {
		return userDAO.idCheck(vo);
	}
	@Override
	public List<AddressVO> findZip(AddressVO vo) {
		return userDAO.findZip(vo);
	}

}
