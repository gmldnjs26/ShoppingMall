package com.spring.kwak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.kwak.dto.QnaVO;
import com.spring.kwak.dto.UserVO;
import com.spring.kwak.service.QnaService;

@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping("qna_list.do")
	public String getQnaList(HttpSession session, Model model) {
		UserVO vo = (UserVO)session.getAttribute("loginUser");
		System.out.println("지금 사용자 아이디: " + vo.getId());
		model.addAttribute("qnaList", qnaService.getQnaList(vo));
		return "qna/qnaList";
	}
	
	@RequestMapping("qna_write_form.do")
	public String qnaWriteForm() {
		return "qna/qnaWrite";
	}
	
	@RequestMapping("qna_write.do")
	public String qnaWrite(HttpSession session, QnaVO vo) {
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		vo.setId(userVO.getId());
		qnaService.insertQna(vo);
		return "redirect:qna_list.do";
	}
	
	@RequestMapping("qna_view.do")
	public String qnaView(QnaVO vo,Model model) {
		model.addAttribute("qnaVO", qnaService.getQna(vo));
		return "qna/qnaView";
	}	
	
}
