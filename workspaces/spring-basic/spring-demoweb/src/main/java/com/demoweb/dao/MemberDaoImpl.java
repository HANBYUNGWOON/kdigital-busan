package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demoweb.vo.MemberVO;

public class MemberDaoImpl implements MemberDao {
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) { // 의존 객체 주입 통로
		this.dataSource = dataSource;
	}
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { // 의존 객체 주입 통로 ( 스프링 IoC에서 DI를 통해 jdbcTemplate에 인스턴스 참조 저장 )
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertMember(MemberVO member) {
			
		// 3. SQL 작성 + 명령 객체 만들기
		String sql = "INSERT INTO member (memberid, passwd, email) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, member.getMemberId(), member.getPasswd(), member.getEmail());
		
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
			// 2. 연결 객체 만들기
			conn = dataSource.getConnection();
			
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
