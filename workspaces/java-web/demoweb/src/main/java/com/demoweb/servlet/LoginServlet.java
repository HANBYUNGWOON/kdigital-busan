package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/account/login.action" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		System.out.printf("[%s][%s]\n", memberId, passwd); // 테스트 코드
		
		//2. 요청 데이터 처리하기 ( 로그인 처리 )
		
		//3. 응답컨텐츠 생산하기 ( JSP로 forward 또는 다른 Servlet으로 redirect )
		resp.sendRedirect("/demoweb/home.action");
		
	}
}






