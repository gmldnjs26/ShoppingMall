package com.spring.kwak.service;

import java.util.List;

import com.spring.kwak.dto.QnaVO;
import com.spring.kwak.dto.UserVO;

public interface QnaService {
	
	// 본인이 등록한 Qna 리스트 가져오기
	public List<QnaVO> getQnaList(UserVO vo);
	
	// Qna 하나 가져오기
	public QnaVO getQna(QnaVO vo);
	
	// Qna 등록 하기
	public void insertQna(QnaVO vo);
}
