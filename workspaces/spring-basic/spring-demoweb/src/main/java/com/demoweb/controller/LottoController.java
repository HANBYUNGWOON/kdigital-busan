package com.demoweb.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.service.LottoService;
import com.demoweb.service.LottoServiceImpl;

@Controller
@RequestMapping(path = { "/lotto" })
public class LottoController {
	
	@GetMapping(path = { "/init-data.action" })
	public String initData(HttpServletRequest req) {
		// 1. 데이터베이스에서 lotto 테이블 drop
		// 2. 데이터베이스에서 lotto 테이블 create
		// 3. lotto 테이블에 데이터 저장
		ServletContext application = req.getServletContext(); // JSP의 application 내장 객체와 같은 객체
		String csvPath = application.getRealPath("/WEB-INF/data-files/lotto-winning-numbers.csv"); // web path (http://....) -> computer path (C:\...)
		LottoService lottoService = new LottoServiceImpl();
		lottoService.initData(csvPath);
		
		System.out.println("init data !!!");
		
		// 4. home으로 redirect (응답컨텐츠 생산)
		return "redirect:/home.action";
	}

}
