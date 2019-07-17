package com.spring.kwak.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.kwak.dto.CartVO;
import com.spring.kwak.dto.UserVO;
import com.spring.kwak.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("cart_list.do")
	public String getListCart(Model model, HttpSession session) {	
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		List<CartVO>cartList = cartService.getListCart(userVO.getId()); // id 만 집어넣고 카트리스트 가져오기
		int totalPrice = 0;
		for(int i=0; i<cartList.size(); i++)
			totalPrice += cartList.get(i).getPrice2();
		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);
		return "mypage/cartList";
	}
	
	@RequestMapping("cart_insert.do")
	public String insertCart(CartVO vo,HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		vo.setId(userVO.getId());
		vo.setMname(userVO.getName());
		cartService.insertCart(vo);
		return "redirect:cart_list.do"; // 다시 한번 카트를 불러오면서 카트 상품들을 가져온다.
	}
	
	@RequestMapping("cart_delete.do")
	public String deleteCart(@RequestParam("cseq")String[] cseqArr) {
		System.out.println("선택된 것들: " + cseqArr.length);
		for(String cseq:cseqArr) {
			System.out.println("삭제 Cart 번호: " + cseq);
			CartVO vo = new CartVO();
			vo.setCseq(Integer.parseInt(cseq));
			cartService.deleteCart(vo); // vo를 하나씩 넣어야하는건가?
		}
		return "redirect:cart_list.do";
	}
}
