import java.util.ArrayList;
import java.util.List;

public class Ex03 {

	public static void main(String[] args)  {
		
		// 데이터베이스로부터 데이터 조회 --> EmployeeDao 객체에 요청
		EmployeeDao dao = new EmployeeDao();
		
		List<EmployeeVO> employees = dao.selectAllEmployees();
		
		for (EmployeeVO e : employees) { // 조회 결과를 순회하면서 출력
			System.out.println(e.toString());
		}
		
//		ArrayList al = new ArrayList(); // Object 형식으로 데이터를 관리하는 컬렉션 객체
//		al.add("Hello");		
//		String str = (String)al.get(0); // 데이터를 읽을 때 형변환 필요
//		int i = (int)al.get(0); // 데이터를 읽을 때 형변환 필요

		ArrayList<String> al2 = new ArrayList<>();
		al2.add("Hello");
		String str2 = al2.get(0); // Generic 형식의 컬렉션에서는 데이터를 읽을 때 형변환 필요 없음
		//int i = (int)al2.get(0);
		
	}

}

// 예외 -> 프로그램 실행 중에 발생하는 관리가능한 오류
// 예외 종류 : Checked Exception , Runtime Exception
