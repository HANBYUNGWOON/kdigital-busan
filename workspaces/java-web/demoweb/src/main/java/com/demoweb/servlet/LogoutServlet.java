package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/account/logout.action" })
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		// 로그아웃 처리 -> 세션에서 데이터 제거
		session.removeAttribute("loginuser"); // 세션에서 loginuser 데이터만 제거 
		// session.invalidate(); // 세션 초기화 (모든 데이터 제거)
		
		// 메인화면으로 이동
		resp.sendRedirect("/demoweb/home.action");
	}

}
