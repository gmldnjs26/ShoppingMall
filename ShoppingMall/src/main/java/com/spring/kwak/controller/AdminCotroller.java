package com.spring.kwak.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.kwak.dto.AdminVO;
import com.spring.kwak.paging.CriteriaVO;
import com.spring.kwak.paging.PageMaker;
import com.spring.kwak.service.AdminService;
import com.spring.kwak.service.CartService;
import com.spring.kwak.service.ProductService;
import com.spring.kwak.service.QnaService;
import com.spring.kwak.service.UserService;

@Controller
@SessionAttributes("admin") // 관리자 아이디 세션에 저장해두기
public class AdminCotroller {
	@Autowired
	private AdminService adminService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("admin_login_form.do")
	public String aLoginForm() {
		return "admin/main2";
	}
	
	@RequestMapping("admin_login.do")
	public String aLogin(AdminVO vo, Model model) {
		System.out.println(vo.getId());
		if(adminService.aLogin(vo) == null) {
			model.addAttribute("message","存在しない管理者IDです");
			return "admin/main2";
		}
		else {
			if(vo.getPwd().equals(adminService.aLogin(vo).getPwd())) {
				model.addAttribute("admin",vo.getId());
				return "redirect:admin_product_list2.do";
			}else {
				model.addAttribute("message", "パスワードが間違っています。");
				return "admin/main2";
			}
		}
	}
	@RequestMapping("admin_product_list2.do")
	public String aGetProductList2(Model model,CriteriaVO cri,@RequestParam(value="pname",required=false)String pname)
	{
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("currp", cri.getPage());
		if(pname == null)
			pname = "";
		map.put("pname", pname);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productService.getTotalRecord(pname));
		System.out.println(pageMaker.getStartPage()+" "+pageMaker.getEndPage()+" "+pageMaker.getTotalCount()+" "+pageMaker.getDisplayPageNum());
		model.addAttribute("productList", productService.getCurrentProductList(map));
		model.addAttribute("pageMaker", pageMaker);
		return "admin/product/productList";
	}

	@RequestMapping("admin_product_list.do")
	public String aGetProductList(Model model,@RequestParam(value="currp",required=false)String currp,@RequestParam(value="pname",required=false)String pname) {
		int totalPage;
		Map<String,Object>map = new HashMap<String,Object>();
		if(currp == null)
			map.put("currp", 1);
		else
			map.put("currp", Integer.parseInt(currp));
		if(pname == null)
			pname = "";
		map.put("pname", pname);
		if(productService.getTotalRecord(pname)%5==0) 
			totalPage = productService.getTotalRecord(pname)/5 + 1;
		else
			totalPage = productService.getTotalRecord(pname)/5;
		System.out.println("totalPage: " + totalPage);
		System.out.println(map.get("currp") +"  "+ map.get("pname"));
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("productList", productService.getCurrentProductList(map));
		return "admin/product/productList";
	}
}
