package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml 파일의 서블릿 설정을 대신하는 annotation
@WebServlet(urlPatterns = { "/hello2" }) // /hello2 경로 요청이 발생하면 이 서블릿 클래스를 호출하는 설정
public class HelloServlet2 extends HttpServlet {
	
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
		out.println("Hello, Servlet Programming World 2 !!!!!");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");		

	}

}
