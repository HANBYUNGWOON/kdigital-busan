package com.demoweb.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoweb.service.LottoService;
import com.demoweb.service.LottoServiceImpl;

@Controller
@RequestMapping(path = { "/lotto" })
public class LottoController {
	
	@Autowired
	@Qualifier("lottoService")
	private LottoService lottoService;
	
	@GetMapping(path = { "/init-data.action" })
	public String initData(HttpServletRequest req) {
		// 1. 데이터베이스에서 lotto 테이블 drop
		// 2. 데이터베이스에서 lotto 테이블 create
		// 3. lotto 테이블에 데이터 저장
		ServletContext application = req.getServletContext(); // JSP의 application 내장 객체와 같은 객체
		String csvPath = application.getRealPath("/WEB-INF/data-files/lotto-winning-numbers.csv"); // web path (http://....) -> computer path (C:\...)
		//LottoService lottoService = new LottoServiceImpl();
		lottoService.initData(csvPath);
		
		System.out.println("init data !!!");
		
		// 4. home으로 redirect (응답컨텐츠 생산)
		return "redirect:/home.action";
	}

	@RequestMapping(path = { "/stats-by-number.action" })
	public String statsByNumbers(
			@RequestParam(defaultValue = "true")boolean includeBno, 
			@RequestParam(defaultValue = "1")int rndFrom, 
			@RequestParam(defaultValue = "977")int rndTo,
			Model model) { // Model type 전달인자 : 컨트롤러에서 뷰로 데이터를 전달하는 통로
		
		//1. 데이터 읽기 ( 전달인자를 통해서 수신 )
		
		if (rndFrom > rndTo) {
			return "redirect:stats-by-numbers.action";
		}
		
		int[] countByNumber = lottoService.loadStatsByNumber(includeBno, rndFrom, rndTo);
		
		// 2. 조회된 데이터를 jsp에서 읽을 수 있도록 request 객체에 저장
		model.addAttribute("countByNumber", countByNumber);
		model.addAttribute("includeBno", includeBno);
		model.addAttribute("rndTo", rndTo);
		model.addAttribute("rndFrom", rndFrom);
		
		return "lotto/stats-by-number"; //	/WEB-INF/views/ + lotto/stats-by-number + .jsp
	}
	
	@RequestMapping(path = { "/stats-by-section.action" })
	public String statsBySection(@RequestParam(defaultValue = "10") int range, 
								 @RequestParam(defaultValue = "5") int weeks,
								Model model) {
		
		int[] countBySection = lottoService.loadStatsBySection(weeks, range);
		model.addAttribute("countBySection", countBySection);
		model.addAttribute("range", range);
		model.addAttribute("weeks", weeks);
		
		return "lotto/stats-by-section";
		
	}
}


