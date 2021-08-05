import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex02 {

	public static void main(String[] args)  {
		
		// 사용자 입력을 받은 것으로 가정
		int employeeNo = 100;
		String nameKey = "S";
		
		Connection conn = null;			// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;	// 명령 객체의 참조를 저장할 변수
		ResultSet rs = null;			// 실행 결과 객체의 참조를 저장할 변수
		
		// 0. 예외 처리 구조 만들기
		try {
			// 1. 드라이버 로딩 (등록)
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. 연결 객체 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@211.197.18.246:1551:xe",	// 사용할 데이터베이스 연결 정보 
					"hr", "oracle");							// 데이터베이스 사용자 계정
			
			// 3. SQL 작성 + 명령 객체 만들기
			// 3-1. 
//			String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE " +
//						 "FROM EMPLOYEES " +
//						 "WHERE EMPLOYEE_ID = " + employeeNo; // 사용자가 입력한 값을 결합해서 SQL문 작성
//			pstmt = conn.prepareStatement(sql);
			
			// 3-2.
//			String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE " +
//					 	 "FROM EMPLOYEES " +
//					 	 "WHERE EMPLOYEE_ID = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, employeeNo); // SQL의 첫 번째 ?에 사용할 데이터 저장
			
			// 3-3.
			String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE " +
					 	 "FROM EMPLOYEES " +
					 	 "WHERE FIRST_NAME LIKE ? OR LAST_NAME LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + nameKey + "%"); // SQL의 첫 번째 ?에 사용할 데이터 저장
			pstmt.setString(2, "%" + nameKey + "%"); // SQL의 두 번째 ?에 사용할 데이터 저장
			
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
			
			// 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
			while (rs.next()) { // 결과집합의 다음 행으로 이동 ( 더이상 데이터가 없다면 false 반환 )
				System.out.printf("[%3d][%15s][%15s][%20s][%s]\n",
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate("HIRE_DATE").toString()); // 현재 행의 컬럼 데이터 읽기
			}
		} catch (Exception ex) {
			ex.printStackTrace();// 콘솔에 오류 메시지를 출력
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		

	}

}

// 예외 -> 프로그램 실행 중에 발생하는 관리가능한 오류
// 예외 종류 : Checked Exception , Runtime Exception
