package com.spring.kwak.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kwak.dto.ProductVO;

@Repository("productDAO")
public class ProductDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 상품 넣기
	public void insertProduct(ProductVO vo) {
		mybatis.insert("ProductDAO.insertProduct",vo);
	}
	
	//신상품 꺼내오기
	public List<ProductVO> getNewProductList(){
		return mybatis.selectList("ProductDAO.getNewProductList");
	}
	
	//베스트 상품 꺼내오기
	public List<ProductVO> getBestProductList(){
		return mybatis.selectList("ProductDAO.getBestProductList");
	}
	
	// 상품 자세한 정보 가져오기
	public ProductVO getProduct(ProductVO vo) {
		return mybatis.selectOne("ProductDAO.getProduct",vo);
	}
	
	// 종류별 상품 정보 가져오기
	public List<ProductVO> getKindListProduct(ProductVO vo){
		return mybatis.selectList("ProductDAO.getKindListProduct",vo);
	}
	
	// 종류별 토탈 상품 갯수 가져오기
	public int getTotalRecord(String pname) {
		return mybatis.selectOne("ProductDAO.getTotalRecord",pname);
	}
	//현재 페이지 상품 목록 가져오기(검색도)
	public List<ProductVO>getCurrentProductList(Map<String,Object>map){
		return mybatis.selectList("ProductDAO.getCurrentProductList", map);
	}
}
