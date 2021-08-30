package com.mvnexample.demoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Connection conn = null;				// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;		// 명령 객체의 참조를 저장할 변수
		ResultSet rs = null;				// 조회 결과의 참조를 저장할 변수
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	// 사용할 데이터베이스 연결 정보 
					"kdigital", "mysql");					// 데이터베이스 사용자 계정
			
			String sql = "SELECT RND, NO1, NO2, NO3 " +
						 "FROM WINNING_NUMBERS ";
			pstmt = conn.prepareStatement(sql);
							
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.printf("%d, %d\n", rs.getInt(1), rs.getInt(2));
			}

			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
    }
}
