package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lotto/stats-by-number.action" })
public class LottoStatsByNumberServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 데이터베이스에서 데이터 조회
		
		// 2. 조회된 데이터를 jsp에서 읽을 수 있도록 request 객체에 저장
		
		// 3. jsp로 forward 이동 (응답컨텐츠 생산)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/lotto/stats-by-numbers.jsp");
		dispatcher.forward(req, resp);
	}

}
