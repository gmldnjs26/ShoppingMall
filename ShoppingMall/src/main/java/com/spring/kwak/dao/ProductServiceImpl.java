package com.spring.kwak.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kwak.dao.ProductDAO;
import com.spring.kwak.dto.ProductVO;
import com.spring.kwak.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public void insertProduct(ProductVO vo) {
		productDAO.insertProduct(vo);
	}

	@Override
	public List<ProductVO> getNewProductList() {
		return productDAO.getNewProductList();
	}

	@Override
	public List<ProductVO> getBestProductList() {
		return productDAO.getBestProductList();
	}
	@Override
	public ProductVO getProduct(ProductVO vo) {
		return productDAO.getProduct(vo);
	}
	
	@Override
	public List<ProductVO> getKindListProduct(ProductVO vo) {
		return productDAO.getKindListProduct(vo);
	}
	@Override
	public int getTotalRecord(String pname) { // pname의 이름이 포함되어있는 전 상품 갯수 가져오기
		if(pname == null)
			pname = "";
		return productDAO.getTotalRecord(pname);
	}
	@Override
	public List<ProductVO> getCurrentProductList(Map<String, Object> map) { // pname -> 상품이름 currp -> 현재페이지
		return productDAO.getCurrentProductList(map);
	}
}
