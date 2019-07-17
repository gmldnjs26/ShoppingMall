package com.spring.kwak.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.kwak.dto.CartVO;
import com.spring.kwak.dto.OrderVO;
import com.spring.kwak.dto.UserVO;
import com.spring.kwak.service.CartService;
import com.spring.kwak.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	CartService cartService;

	@RequestMapping("order_insert.do")
	public String insertOrder(HttpSession session,@RequestParam("cseq")String[] cseqArr) {
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		List<CartVO>cartList = cartService.getListCart(userVO.getId());
		
		for(String cseq:cseqArr) {
			for(int i=0; i < cartList.size(); i++) {
				if(Integer.parseInt(cseq) == cartList.get(i).getCseq()) {
					OrderVO vo = new OrderVO();
					vo.setId(userVO.getId());
					vo.setPseq(cartList.get(i).getPseq());
					vo.setQuantity(cartList.get(i).getQuantity());
					orderService.insertOrder(vo);
				}
			}
		}
		return "redirect:order_all.do";
	}
	
	@RequestMapping("mypage.do")
	public String mypage(Model model,HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		model.addAttribute("orderList", orderService.getOrderList(userVO.getId()));
		model.addAttribute("title", userVO.getName());
		return "mypage/mypage";
	}
	
	@RequestMapping("order_all.do")
	public String getAllOrderList(Model model,HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		List<OrderVO>orderList = orderService.getAllListOrder(userVO.getId());
		int totalPrice = 0;
		for(int i=0; i<orderList.size(); i++)
			totalPrice += orderList.get(i).getPrice2();
		model.addAttribute("orderList",orderList);
		model.addAttribute("totalPrice", totalPrice);
		return "mypage/orderList";
	}
}
