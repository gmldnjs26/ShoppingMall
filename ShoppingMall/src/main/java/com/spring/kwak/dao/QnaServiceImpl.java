package com.spring.kwak.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kwak.dto.QnaVO;
import com.spring.kwak.dto.UserVO;
import com.spring.kwak.service.QnaService;

@Service(value="qnaService")
public class QnaServiceImpl implements QnaService{
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public QnaVO getQna(QnaVO vo) {
		return qnaDAO.getQna(vo);
	}
	
	@Override
	public List<QnaVO> getQnaList(UserVO vo) {
		return qnaDAO.getQnaList(vo);
	}
	
	@Override
	public void insertQna(QnaVO vo) {
		qnaDAO.insertQna(vo);
	}
}
