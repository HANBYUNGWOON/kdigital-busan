package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demoweb.vo.MemberVO;

public class MemberDaoImpl implements MemberDao {
	
	@Override
	public void insertMember(MemberVO member) {
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
			pstmt.setString(1, member.getMemberId()); // SQL의 첫 번째 ?에 사용할 데이터 저장
			pstmt.setString(2, member.getPasswd()); // SQL의 두 번째 ?에 사용할 데이터 저장
			pstmt.setString(3, member.getEmail()); // SQL의 세 번째 ?에 사용할 데이터 저장
			
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
	}

	@Override
	public MemberVO selectMemberByIdAndPasswd(String memberId, String passwd) {
		
		Connection conn = null;			// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;	// 명령 객체의 참조를 저장할 변수
		ResultSet rs = null;			// 실행 결과 객체의 참조를 저장할 변수
		MemberVO member = null;			// 조회 결과를 저장할 변수
		
		// 0. 예외 처리 구조 만들기
		try {
			// 1. 드라이버 로딩 (등록)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 객체 만들기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	// 사용할 데이터베이스 연결 정보 
					"kdigital", "mysql");							// 데이터베이스 사용자 계정
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT memberid, email, usertype, regdate " +
						 "FROM member WHERE active = true AND memberid = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); // SQL의 첫 번째 ?에 사용할 데이터 저장
			pstmt.setString(2, passwd); // SQL의 두 번째 ?에 사용할 데이터 저장
			
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
			
			// 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
			if (rs.next()) { // 결과집합의 다음 행으로 이동 ( 더이상 데이터가 없다면 false 반환 )
				member = new MemberVO();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setUserType(rs.getString(3));
				member.setRegDate(rs.getDate(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();// 콘솔에 오류 메시지를 출력
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return member;
	}
}
