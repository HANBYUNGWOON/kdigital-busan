package com.examplesweb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/model2" })
public class Model2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 요청 데이터 읽기		
		//2. 요청 처리
		
		//3. JSP에서 사용하도록 데이터 전달 ( forward로 이동하기 때문에 request 객체에 데이터 저장해서 전달 )
		req.setAttribute("date", new Date());
		
		//4. 응답 컨텐츠 생산 ( JSP에서 처리하도록 forward )
		RequestDispatcher dispatcher = req.getRequestDispatcher("e.model2.jsp");
		dispatcher.forward(req, resp);

	}
	
}




