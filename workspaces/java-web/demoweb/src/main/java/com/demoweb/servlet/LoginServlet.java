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
		
		// jdbc 코드 구현 : memberId, passwd로 member의 count 조회
		//                count > 0 : 로그인 처리 / count == 0이면 로그인 실패 처리
		Connection conn = null;			// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;	// 명령 객체의 참조를 저장할 변수
		ResultSet rs = null;			// 실행 결과 객체의 참조를 저장할 변수
		int count = 0; 					// 조회 결과를 저장할 변수
		
		// 0. 예외 처리 구조 만들기
		try {
			// 1. 드라이버 로딩 (등록)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 객체 만들기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	// 사용할 데이터베이스 연결 정보 
					"kdigital", "mysql");							// 데이터베이스 사용자 계정
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT COUNT(*) FROM member WHERE memberid = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); // SQL의 첫 번째 ?에 사용할 데이터 저장
			pstmt.setString(2, passwd); // SQL의 두 번째 ?에 사용할 데이터 저장
			
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
			
			// 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
			if (rs.next()) { // 결과집합의 다음 행으로 이동 ( 더이상 데이터가 없다면 false 반환 )
				count = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();// 콘솔에 오류 메시지를 출력
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
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






