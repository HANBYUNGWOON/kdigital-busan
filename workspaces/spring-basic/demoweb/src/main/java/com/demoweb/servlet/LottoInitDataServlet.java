package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.service.LottoService;

@WebServlet(urlPatterns = { "/lotto/init-data.action" })
public class LottoInitDataServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 데이터베이스에서 lotto 테이블 drop
		// 2. 데이터베이스에서 lotto 테이블 create
		// 3. lotto 테이블에 데이터 저장
		ServletContext application = req.getServletContext(); // JSP의 application 내장 객체와 같은 객체
		String csvPath = application.getRealPath("/upload-files/lotto-winning-numbers.csv"); // web path (http://....) -> computer path (C:\...)
		LottoService lottoService = new LottoService();
		lottoService.initData(csvPath);
		
		// 4. home으로 redirect (응답컨텐츠 생산)
		resp.sendRedirect("/demoweb/home.action");
		
	}

}
