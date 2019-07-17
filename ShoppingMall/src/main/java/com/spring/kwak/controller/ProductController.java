package com.spring.kwak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.kwak.dto.ProductVO;
import com.spring.kwak.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	// 추후 관리자
	@RequestMapping(value="/insertProduct.do")
	public void insertProduct(ProductVO productVO) {
		productService.insertProduct(productVO);
	}
	
	// 상품 자세한 정보 가져오기
	@RequestMapping(value="product_detail.do")
	public String getProduct(ProductVO vo,Model model ) {
		model.addAttribute("productVO",productService.getProduct(vo));
		return "product/productDetail";
	}
	
	// 종류별 상품 리스트 가져오기
	@RequestMapping(value="category.do")
	public String getKindListProduct(ProductVO vo, Model model) {
		model.addAttribute("productKindList", productService.getKindListProduct(vo));
		return "product/productKind";
	}
}
