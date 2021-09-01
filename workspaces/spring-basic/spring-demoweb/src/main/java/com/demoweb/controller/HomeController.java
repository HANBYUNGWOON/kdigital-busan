package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 1. IoC 컨테이너에 등록 (@Component), 2. HandlerMapping에 등록 ( 요청 처리기로 등록 )
@RequestMapping(path = { "/" })
public class HomeController {
	
	//@RequestMapping(path = { "/", "/home.action" }, method = RequestMethod.GET)
	@GetMapping(path = { "/", "/home.action" })
	public String home() {
		
		return "home";	//  /WEB-INF/views/ + home + .jsp -> /WEB-INF/views/home.jsp
	}

}
