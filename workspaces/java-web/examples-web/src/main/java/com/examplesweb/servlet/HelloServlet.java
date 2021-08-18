package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	// Web Application을 대상으로 Get 요청이 발생하면 호출되는 메서드 구현
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();	// PrintWriter : NetworkStream에 데이터를 기록하는 Text Format I/O 객체
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello, Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style='text-align:center; color:red'>");
		out.println("Hello, Servlet Programming World !!!!!");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");		

	}

}
