package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.service.AuthService;
import com.demoweb.service.AuthServiceImpl;
import com.demoweb.vo.MemberVO;

@Controller
@RequestMapping(path = { "/account" })
public class AccountController {
	
	@Autowired
	@Qualifier("authService") // <bean id="authService" ...>인 객체를 주입
	private AuthService authService;	
	
	@GetMapping(path = { "/register.action" })
	public String showRegisterForm() {
		
		return "account/register"; // /WEB-INF/views/ + account/register + .jsp
	}
	
	@PostMapping(path = { "/register.action" })
	public String register(MemberVO member) {
		
		//1. 데이터 읽기 ( 전달인자로 대체 )
		
		//2. 데이터 처리 ( 데이터베이스에 회원 정보 저장 )
		//AuthService authService = new AuthServiceImpl();
		authService.registerMember(member);
		
		//3. 로그인 화면으로 이동 ( redirect )
		return "redirect:login.action"; // http://localhost:8081/spring-demoweb/account/login.action
	}
	
	@GetMapping(path = { "/login.action" })
	public String showLoginForm() {
		
		return "account/login";  // /WEB-INF/views/ + account/login + .jsp
	}
	
	@PostMapping(path = { "/login.action" })
	public String login(String memberId, String passwd, HttpSession session) {
		
		//1. 데이터 읽기 ( 전달인자로 대체 )
		
		//2. 데이터 처리 ( 데이터베이스에서 데이터 조회 -> 조회 결과에 따라 세션에 데이터 저장 or 로그인 화면으로 이동 )
		//AuthService authService = new AuthServiceImpl();
		MemberVO member = authService.findMemberByIdAndPasswd(memberId, passwd);
		
		if (member != null) {
			// 전달인자로 받은 세션 사용
			session.setAttribute("loginuser", member); // 로그인 처리 -> session 객체에 데이터 저장
			
			//3. 응답컨텐츠 생산하기 ( JSP로 forward 또는 다른 Servlet으로 redirect )
			return "redirect:/home.action";
		} else {
			return "redirect:/account/login.action";
		}
	}
	
	@GetMapping(path = { "/logout.action" })
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginuser");
		
		return "redirect:/home.action";
	}
	
}














