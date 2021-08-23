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

@WebServlet(urlPatterns = { "/account/register.action" })
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		System.out.printf("[%s][%s][%s][%s]\n", memberId, passwd, confirm, email);
		
		//2. 요청 데이터 처리 ( 회원가입처리 )
		
		Connection conn = null;			// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;	// 명령 객체의 참조를 저장할 변수
		
		// 0. 예외 처리 구조 만들기
		try {
			// 1. 드라이버 로딩 (등록)
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 객체 만들기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	// 사용할 데이터베이스 연결 정보 
					"kdigital", "mysql");							// 데이터베이스 사용자 계정
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "INSERT INTO member (memberid, passwd, email) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); // SQL의 첫 번째 ?에 사용할 데이터 저장
			pstmt.setString(2, passwd); // SQL의 두 번째 ?에 사용할 데이터 저장
			pstmt.setString(3, email); // SQL의 세 번째 ?에 사용할 데이터 저장
			
			// 4. 명령 실행
			pstmt.executeUpdate(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
			
			// 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
		} catch (Exception ex) {
			ex.printStackTrace();// 콘솔에 오류 메시지를 출력
		} finally {
			// 6. 연결 닫기
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		//3. 응답 컨텐츠 생산 ( JSP로 forward or Servlet으로 redirect )
		resp.sendRedirect("login.action");
		
	}
}
