package com.springexample.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
//	@RequestMapping(path = { "/demo/param.action" })
//	public String processGetRequest(HttpServletRequest req) {
//		
//		// 데이터 읽기
//		String data1 = req.getParameter("data1");
//		String data2 = req.getParameter("data2");
//		System.out.printf("data1 = %s, data2 = %s\n", data1, data2);
//		
//		return "result";	// /WEB-INF/views/ + result + .jsp
//	}
	
	@RequestMapping(path = { "/demo/param.action" })
	public String processGetRequest(String data1, int data2) {
		
		// 데이터 읽기 (전달인자에서 직접 수신)
		System.out.printf("data1 = %s, data2 = %d\n", data1, data2);
		
		return "result";	// /WEB-INF/views/ + result + .jsp
	}

}
