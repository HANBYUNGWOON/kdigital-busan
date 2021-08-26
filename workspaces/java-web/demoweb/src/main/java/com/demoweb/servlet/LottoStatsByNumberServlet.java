package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.service.LottoService;

@WebServlet(urlPatterns = { "/lotto/stats-by-number.action" })
public class LottoStatsByNumberServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		req.getParameter("a"); // 입력 요소에 입력된 값 (클라이언트가 요청과 함께 전송한 데이터)
//		req.getAttribute("b"); // req.setAttribute("b") 로 저장한 값
		
		// 0. 요청 데이터 읽기
		boolean includeBno = true;
		int rndFrom = 1;
		int rndTo = 977;
		// req.getParameter("includeBno") -> <select name="includeBno" or <input type="text" name="includeBno" or ... 에 입력된 값 읽기
		if (req.getParameter("includeBno") != null) {			
			includeBno = req.getParameter("includeBno").equals("1"); // 1 : 포함, 0 : 미포함			
		}
		if (req.getParameter("rndFrom") != null) {
			try {
				rndFrom = Integer.parseInt(req.getParameter("rndFrom"));
			} catch (Exception ex) {
				rndFrom = 1;
			}
		}
		if (req.getParameter("rndTo") != null) {
			rndTo = Integer.parseInt(req.getParameter("rndTo"));
		}
		
		//System.out.printf("%d, %d", rndFrom, rndTo);
		if (rndTo < rndFrom) {
			resp.sendRedirect("stats-by-numbers.action");
			return;
		}
		
		// 1. 데이터베이스에서 데이터 조회
		LottoService lottoService = new LottoService();
		int[] countByNumber = lottoService.loadStatsByNumber(includeBno, rndFrom, rndTo);
		//System.out.printf("%d, %d, %d\n", countByNumber[0], countByNumber[1], countByNumber[2]);
		
		// 2. 조회된 데이터를 jsp에서 읽을 수 있도록 request 객체에 저장
		req.setAttribute("countByNumber", countByNumber);
		req.setAttribute("includeBno", includeBno);
		req.setAttribute("rndTo", rndTo);
		req.setAttribute("rndFrom", rndFrom);
		
		// 3. jsp로 forward 이동 (응답컨텐츠 생산)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/lotto/stats-by-number.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}








