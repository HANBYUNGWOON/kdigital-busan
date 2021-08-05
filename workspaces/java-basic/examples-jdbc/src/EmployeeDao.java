import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * HR 계정의 Employees 테이블에 대한 데이터베이스 연동 로직을 구현한 클래스
 * 
 * @author instructor
 *
 */
public class EmployeeDao {
	
	/**
	 * 다른 클래스의 Employees 테이블 조회 요청을 처리하는 메서드
	 * 
	 * @return 조회된 전체 직원 데이터를 List<EmployeeVO> 형식으로 반환
	 */
	public List<EmployeeVO> selectAllEmployees() {
		
		Connection conn = null;			// 연결 객체의 참조를 저장할 변수
		PreparedStatement pstmt = null;	// 명령 객체의 참조를 저장할 변수
		ResultSet rs = null;			// 실행 결과 객체의 참조를 저장할 변수
		
		ArrayList<EmployeeVO> employees = new ArrayList<>(); // 데이터베이스에서 조회한 결과를 저장할 컬렉션 객체
		
		// 0. 예외 처리 구조 만들기
		try {
			// 1. 드라이버 로딩 (등록)
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. 연결 객체 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@211.197.18.246:1551:xe",	// 사용할 데이터베이스 연결 정보 
					"hr", "oracle");							// 데이터베이스 사용자 계정
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE " +
						 "FROM EMPLOYEES ";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
			
			// 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
			while (rs.next()) { // 결과집합의 다음 행으로 이동 ( 더이상 데이터가 없다면 false 반환 )
				EmployeeVO e = new EmployeeVO(); // 한 행의 데이터를 저장할 VO 인스턴스 만들기
				e.setEmployeeNo(rs.getInt(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setHireDate(rs.getDate("HIRE_DATE"));
				employees.add(e); // 저장된 한 행의 데이터를 결과 저장을 위해 만든 컬렉션 객체에 추가
			}
		} catch (Exception ex) {
			ex.printStackTrace();// 콘솔에 오류 메시지를 출력
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return employees; // 조회된 데이터를 저장한 컬렉션 객체 반환
		
	}

}
