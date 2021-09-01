package com.springexample.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
			@RequestParam(required = false, defaultValue = "0") Integer test,
			Model model) { // Model 형식의 전달인자는 요청데이터와 관계 없습니다. View로 전달할 데이터를 저장하기 위한 변수. 여기에 저장하면 request 객체에 저장
		
		// 데이터 읽기 (전달인자에서 직접 수신)
		System.out.printf("data1 = %s, data2 = %d, test = %d\n", msg, cnt, test);
		
		// JSP에서 읽을 수 있도록 데이터 저장
		model.addAttribute("msg", msg);	// --> req.setAttribute("msg", msg)
		model.addAttribute("cnt", cnt);
		model.addAttribute("test", test);
		
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
//	@PostMapping(path = { "/demo/param.action" })
//	public String processPostRequest(String name, String phone, String email, int age) {
//		
//		// 데이터 읽기 (전달인자에서 직접 수신)
//		System.out.printf("name = %s, phone = %s, email = %s, age = %d\n", name, phone, email, age);
//		
//		Person person = new Person();
//		person.setName(name);
//		person.setEmail(email);
//		person.setPhone(phone);
//		person.setAge(age);
//		
//		return "result";	// /WEB-INF/views/ + result + .jsp
//	}
	
	@PostMapping(path = { "/demo/param.action" })
	public ModelAndView processPostRequest(
			Model model,
			Person person) { // VO 전달인자는 자동으로 request객체에 저장 : @ModelAttribute Person person
		
		// 데이터 읽기 (전달인자에서 직접 수신)
		System.out.printf("name = %s, phone = %s, email = %s, age = %d\n", 
						  person.getName(), person.getPhone(), person.getEmail(), person.getAge());
		
		model.addAttribute("myperson", person); // request.setAttribute("myperson", person)과 같은 의미
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");			// /WEB-INF/views/ + result + .jsp
		mav.addObject("myperson2", person); // --> request.setAttribute("myperson2", person);
		
		return mav;	// 
	}
	
	////////////////////////
	
	@GetMapping(path = { "/demo/redirect.action" })
	public String redirect() {
		
		// return "home";   		//  /WEB-INF/views/ + home + .jsp
		// return "home.action";	//	/WEB-INF/views/ + home.action + .jsp
		return "redirect:/home.action";
	}
	
	@GetMapping(path = { "/demo/forward.action" })
	public String forward() {
		return "forward:/resources/forward.html";
	}
	
	
}









