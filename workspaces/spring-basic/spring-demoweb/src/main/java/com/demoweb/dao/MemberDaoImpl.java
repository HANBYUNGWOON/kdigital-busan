package com.demoweb.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		
		String sql = "SELECT memberid, email, usertype, regdate " +
					 "FROM member WHERE active = true AND memberid = ? AND passwd = ?";
		
		MemberVO member = jdbcTemplate.queryForObject(
				sql, // SQL문
				new RowMapper<MemberVO>() { // 1.RowMapper<MemberVO> 인터페이스를 구현하는 이름 없는 클래스 만들기 + 2. 1에서 만든 클래스의 인스턴스 만들기
					// JdbcTemplate에서 호출하는 결과 처리 메서드
					@Override
					public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						MemberVO member = new MemberVO();
						member.setMemberId(rs.getString(1));
						member.setEmail(rs.getString(2));
						member.setUserType(rs.getString(3));
						member.setRegDate(rs.getDate(4));
						return member;
					}
				}, 
				memberId, passwd); // SQL문에서 사용할 데이터 목록
		
		return member;
	}


}















