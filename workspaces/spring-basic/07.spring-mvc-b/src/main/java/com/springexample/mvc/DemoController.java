package com.springexample.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
//	@RequestMapping(path = { "/demo/param.action" })
//	public String processGetRequest(String data1, int data2) {
//		
//		// 데이터 읽기 (전달인자에서 직접 수신)
//		System.out.printf("data1 = %s, data2 = %d\n", data1, data2);
//		
//		return "result";	// /WEB-INF/views/ + result + .jsp
//	}
	
	//@RequestMapping(path = { "/demo/param.action" }, method = RequestMethod.GET)
	@GetMapping(path = { "/demo/param.action" })
	public String processGetRequest(
			@RequestParam(name = "data1") String msg, 
			@RequestParam(name = "data2") int cnt,
			@RequestParam(required = false, defaultValue = "0") Integer test) {
		
		// 데이터 읽기 (전달인자에서 직접 수신)
		System.out.printf("data1 = %s, data2 = %d, test = %d\n", msg, cnt, test);
		
		return "result";	// /WEB-INF/views/ + result + .jsp
	}

	//@RequestMapping(path = { "/demo/param.action" }, method = RequestMethod.POST)
//	@PostMapping(path = { "/demo/param.action" })
//	public String processPostRequest(String name, String phone, String email, int age) {
//		
//		// 데이터 읽기 (전달인자에서 직접 수신)
//		System.out.printf("name = %s, phone = %s, email = %s, age = %d\n", name, phone, email, age);
//		
//		return "result";	// /WEB-INF/views/ + result + .jsp
//	}
	
	//@RequestMapping(path = { "/demo/param.action" }, method = RequestMethod.POST)
	@PostMapping(path = { "/demo/param.action" })
	public String processPostRequest(String name, String phone, String email, int age) {
		
		// 데이터 읽기 (전달인자에서 직접 수신)
		System.out.printf("name = %s, phone = %s, email = %s, age = %d\n", name, phone, email, age);
		
		return "result";	// /WEB-INF/views/ + result + .jsp
	}
	
	
}









