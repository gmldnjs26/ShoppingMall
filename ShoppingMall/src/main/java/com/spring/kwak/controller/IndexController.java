package com.spring.kwak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.kwak.dto.ProductVO;
import com.spring.kwak.service.ProductService;

@Controller
public class IndexController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/index.do")
	public String index(ProductVO vo, Model model) {
		model.addAttribute("newProductList", productService.getNewProductList());
		model.addAttribute("bestProductList", productService.getBestProductList());
		return "index";
	}
}
