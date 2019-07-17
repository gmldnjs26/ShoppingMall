package com.spring.kwak.service;

import java.util.List;
import java.util.Map;

import com.spring.kwak.dto.ProductVO;

public interface ProductService {
	
	//상품 넣기
	void insertProduct(ProductVO vo);
	
	//신상품 리스트 가져오기
	public List<ProductVO> getNewProductList();
	
	//베스트 상품 리스트 가져오기
	public List<ProductVO> getBestProductList();
	
	//상품 자세한 정보 가져오기
	public ProductVO getProduct(ProductVO vo);
	
	//종류별 상품 리스트 가져오기
	public List<ProductVO> getKindListProduct(ProductVO vo);
	
	//종류별 토탈 상품 갯수 가져오기
	public int getTotalRecord(String pname);
	
	//현재 페이지 상품 목록 가져오기(검색도)
	public List<ProductVO>getCurrentProductList(Map<String,Object>map);
} 
