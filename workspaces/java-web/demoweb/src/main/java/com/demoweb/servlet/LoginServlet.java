package com.demoweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		

		int count = 0;
		if (count > 0) {
			// 서블릿에서는 session JSP와 같이 내장 객체가 아니기 때문에 req.getSession() 으로 세션 가져오기 수행
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", memberId); // 로그인 처리 -> session 객체에 데이터 저장
			
			//3. 응답컨텐츠 생산하기 ( JSP로 forward 또는 다른 Servlet으로 redirect )
			resp.sendRedirect("/demoweb/home.action");
		} else {
			resp.sendRedirect("login.action");
		}
		
		
		
	}
}






