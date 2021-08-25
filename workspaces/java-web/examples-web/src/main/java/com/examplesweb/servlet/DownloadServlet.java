package com.examplesweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/download" })
public class DownloadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 다운로드 요청된 파일이름 읽기
		String fileName = req.getParameter("file");
		
		// 요청 데이터에 파일이름이 없으면 목록으로 이동 
		if (fileName == null) {
			resp.sendRedirect("g.file-list.jsp");
			return;
		}
		
	}

}
