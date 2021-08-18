package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello3")
public class HelloServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();	// PrintWriter : NetworkStream에 데이터를 기록하는 Text Format I/O 객체
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello, Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style='text-align:center; color:red'>");
		out.println("Hello, Servlet Programming World 3 !!!!!");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
