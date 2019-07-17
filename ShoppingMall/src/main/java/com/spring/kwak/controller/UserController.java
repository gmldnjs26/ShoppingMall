package com.spring.kwak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.kwak.dto.AddressVO;
import com.spring.kwak.dto.UserVO;
import com.spring.kwak.service.UserService;

@Controller
@SessionAttributes("loginUser")
public class UserController {
	@Autowired
	private UserService userService;
	// 로그인 sql 로 줄이는게 좋을까 자바코드를 줄이는게 좋을까..?
	// 아이디 틀렸는지 비밀번호 틀렸는지 가르쳐 줘야하나?
	@RequestMapping(value = "login.do")
	public String login(UserVO vo, Model model) {
		UserVO userVO = userService.login(vo);
		if (userVO != null && userVO.getPwd().equals(vo.getPwd())) {
			model.addAttribute("loginUser", userService.login(vo));
			return "redirect:index.do"; // ViewResolver 무시하고 바로 이동
		} else {
			return "member/login_fail";
		}
	}
	// 로그아웃
	@RequestMapping(value = "logout.do")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:index.do";
	}

	// 회원가입 전 동의 페이지로 이동
	@RequestMapping(value = "contract.do")
	public String contract() {
		return "member/contract";
	}

	// 회원가입 양식
	@RequestMapping(value = "join_form.do")
	public String join_form() {
		return "member/join";
	}

	// 로그인 양식
	@RequestMapping(value = "login_form.do")
	public String login_form() {
		return "member/login";
	}

	// 회원가입
	@RequestMapping(value = "join.do")
	public String join(UserVO vo) {
		userService.join(vo);
		System.out.println("회원 가입 완료");
		return "member/login";
	}

	// 아이디 중복 확인
	@RequestMapping(value = "id_check_form.do")
	public String idCheck(UserVO vo, Model model) {
		int message;
		if (userService.idCheck(vo) != null)
			message = 0;
		else
			message = 1;
		model.addAttribute("message", message);
		model.addAttribute("id", vo.getId());
		return "member/idcheck";
	}

	// 전국 시 구 동 찾아주기
	@RequestMapping(value = "find_zip_num.do")
	public String findZip(AddressVO vo, Model model) {
		if (vo.getDong() != null)
			model.addAttribute("addressList", userService.findZip(vo));
		return "member/findZipNum";
	}

	// ----------------------------------추후 Spring Security 부분에 대해서 좀더 배우면
	// 해보자----------------------------------------
	// 아이디 비밀번호 찾기
	@RequestMapping(value = "find_id_form.do")
	public String findIdPwd() {
		return "member/findIdAndPassword";
	}
}
