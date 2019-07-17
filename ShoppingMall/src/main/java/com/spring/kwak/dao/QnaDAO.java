package com.spring.kwak.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kwak.dto.QnaVO;
import com.spring.kwak.dto.UserVO;

@Repository("qnaDAO")
public class QnaDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 본인이 등록 Qna리스트 가져오기
	public List<QnaVO>getQnaList(UserVO vo){
		return mybatis.selectList("QnaDAO.getQnaList", vo);
	}
	
	// Qna 하나 가져오기
	public QnaVO getQna(QnaVO vo) {
		return mybatis.selectOne("QnaDAO.getQna", vo);
	}
	
	// Qna 등록 하기
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
}
