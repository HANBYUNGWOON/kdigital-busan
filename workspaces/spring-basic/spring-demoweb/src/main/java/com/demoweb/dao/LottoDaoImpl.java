package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.demoweb.vo.WinningNumbers;

public class LottoDaoImpl implements LottoDao {

	@Override
	public void dropWinningNumbersTable() {

		Connection conn = null;	
		PreparedStatement pstmt = null;	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",
					"kdigital", "mysql");
			
			String sql = "DROP TABLE WINNING_NUMBERS ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println("테이블을 삭제할 수 없습니다.");
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	@Override
	public void createWinningNumbersTable() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로딩 (등록)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 객체 만들기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", 
					"kdigital", "mysql");
			
			String sql = "CREATE TABLE WINNING_NUMBERS ( " +
						 "	RND INT PRIMARY KEY, " +
						 "	LOTTERY_DATE DATE NOT NULL, " +
						 "	NO1 INT NOT NULL CHECK(NO1 >= 1 AND NO1 <= 45), " +
						 "	NO2 INT NOT NULL CHECK(NO2 >= 1 AND NO2 <= 45), " +
						 "	NO3 INT NOT NULL CHECK(NO3 >= 1 AND NO3 <= 45), " +
						 "	NO4 INT NOT NULL CHECK(NO4 >= 1 AND NO4 <= 45), " +
						 "	NO5 INT NOT NULL CHECK(NO5 >= 1 AND NO5 <= 45), " +
						 "	NO6 INT NOT NULL CHECK(NO6 >= 1 AND NO6 <= 45), " +
						 "	BNO INT NOT NULL CHECK(BNO >= 1 AND BNO <= 45) " +
						 ")";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println("테이블 생성 실패");
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	@Override
	public void insertWinningNumbers(WinningNumbers wn) {

		Connection conn = null;			// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;	// 명령 객체의 참조를 저장할 변수
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	// 사용할 데이터베이스 연결 정보 
					"kdigital", "mysql");				// 데이터베이스 사용자 계정
			
			String sql = "INSERT INTO WINNING_NUMBERS (RND, LOTTERY_DATE, NO1, NO2, NO3, NO4, NO5, NO6, BNO) " +
						 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wn.getRnd());
			// java.util.Date --> java.sql.Date
			// java.util.Date.getTime() : 1970년 1월 1일 0시 0분 0초로부터 경과된 1/1000 초단위의 경과 값
			pstmt.setDate(2, new java.sql.Date(wn.getLotteryDate().getTime()));
			pstmt.setInt(3, wn.getNo1());
			pstmt.setInt(4, wn.getNo2());
			pstmt.setInt(5, wn.getNo3());
			pstmt.setInt(6, wn.getNo4());
			pstmt.setInt(7, wn.getNo5());
			pstmt.setInt(8, wn.getNo6());
			pstmt.setInt(9, wn.getBno());
			
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}
	
	// 한 번에 여러 개의 데이터를 insert하는 메서드
	@Override
	public void insertWinningNumbers2(List<WinningNumbers> numbers) {

		Connection conn = null;			// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;	// 명령 객체의 참조를 저장할 변수
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	// 사용할 데이터베이스 연결 정보 
					"kdigital", "mysql");				// 데이터베이스 사용자 계정
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO WINNING_NUMBERS (RND, LOTTERY_DATE, NO1, NO2, NO3, NO4, NO5, NO6, BNO) " +
						 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			
			for (WinningNumbers wn : numbers) {
				pstmt.setInt(1, wn.getRnd());
				// java.util.Date --> java.sql.Date
				// java.util.Date.getTime() : 1970년 1월 1일 0시 0분 0초로부터 경과된 1/1000 초단위의 경과 값
				pstmt.setDate(2, new java.sql.Date(wn.getLotteryDate().getTime()));
				pstmt.setInt(3, wn.getNo1());
				pstmt.setInt(4, wn.getNo2());
				pstmt.setInt(5, wn.getNo3());
				pstmt.setInt(6, wn.getNo4());
				pstmt.setInt(7, wn.getNo5());
				pstmt.setInt(8, wn.getNo6());
				pstmt.setInt(9, wn.getBno());
				pstmt.addBatch();
			}
			
			pstmt.executeBatch(); // 일괄 처리 -> 한 번에 여러 개를 insert
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}
	
	// 번호별로 1등 당첨에 포함된 횟수 조회
	@Override
	public int[] selectStatsByNumber(boolean includeBno, int rndFrom, int rndTo) {

		Connection conn = null;				// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;		// 명령 객체의 참조를 저장할 변수
		ResultSet rs = null;				// 조회 결과의 참조를 저장할 변수
		int[] countByNumber = new int[45];	// 번호별 당첨 횟수를 저장할 배열
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	// 사용할 데이터베이스 연결 정보 
					"kdigital", "mysql");					// 데이터베이스 사용자 계정
			
			String sql = "SELECT COUNT(*) " +
						 "FROM WINNING_NUMBERS " +
						 "WHERE (RND >= ? AND RND <= ?) AND (NO1=? OR NO2=? OR NO3=? OR NO4=? OR NO5=? OR NO6=? ";
			if (includeBno) {
				sql += "OR BNO=? ";
			}
			sql += ") ";
			
			pstmt = conn.prepareStatement(sql);
			
			for (int no = 1; no <= 45; no++) { // 숫자 1 ~ 45까지 당첨 횟수를 뽑기 위한 반복문
				pstmt.clearParameters();// 앞에서 지정한 파라미터 값 제거

				pstmt.setInt(1, rndFrom);
				pstmt.setInt(2, rndTo);
				
				for (int i = 3; i <= 8; i++) { // SQL의 ?를 채우기 위한 반복문
					pstmt.setInt(i, no);
				}
				if (includeBno) {
					pstmt.setInt(9, no);					
				}
				
				rs = pstmt.executeQuery();
				rs.next();// 무조건 결과가 1개 있는 조회이기 때문에 if 또는 while 을 사용하지 않았습니다
				int count = rs.getInt(1);
				countByNumber[no-1] = count;
				rs.close();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return countByNumber;
		
	}
	
}












