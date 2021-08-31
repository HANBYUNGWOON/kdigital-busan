package com.springexample.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(path = { "/", "/home" }, method = RequestMethod.GET)
	public String home() {
		
		return "home"; // view 이름을 DispatcherServlet에게 반환 --> /WEB-INF/views/ + home + .jsp
	}
	
}
