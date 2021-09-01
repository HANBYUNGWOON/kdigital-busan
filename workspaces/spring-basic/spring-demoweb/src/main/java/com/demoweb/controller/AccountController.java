package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.service.AuthService;
import com.demoweb.vo.MemberVO;

@Controller
@RequestMapping(path = { "/account" })
public class AccountController {
	
	@GetMapping(path = { "/register.action" })
	public String showRegisterForm() {
		
		return "account/register"; // /WEB-INF/views/ + account/register + .jsp
	}
	
	@PostMapping(path = { "/register.action" })
	public String register(MemberVO member) {
		
		//1. 데이터 읽기 ( 전달인자로 대체 )
		
		//2. 데이터 처리 ( 데이터베이스에 회원 정보 저장 )
		AuthService authService = new AuthService();
		authService.registerMember(member);
		
		//3. 로그인 화면으로 이동 ( redirect )
		return "redirect:login.action"; // http://localhost:8081/spring-demoweb/account/login.action
	}
	
}
