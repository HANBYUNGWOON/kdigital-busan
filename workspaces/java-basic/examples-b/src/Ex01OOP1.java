
// class : 구현 대상을 문법접으로 표현
//         사용자 정의 자료형 ( 참조형 )
class Employee {
	//특성 - (멤버)변수 ( 필드 )
	int empNo;
	String name;
	String email;
	
	//기능 - (멤버)메서드
	String info() {
		//String.format : System.out.printf 과 동일한 형식으로 사용하되 문자열만 만들고 출력 기능은 빠진 메서드
		String info = String.format("[%d][%s][%s]", empNo, name, email);
		return info;
	}
}
public class Ex01OOP1 {

	public static void main(String[] args) {
		
		//int x = 10; // 4byte 정수형 변수(공간) 만들기
		
		// 클래스 사용 : 클래스 타입의 변수 만들기 + 데이터 저장/읽기 + 기능 호출
		Employee emp;			// 참조 변수 만들기
		emp = new Employee();	// 인스턴스 만들기 + 인스턴스의 주소를 참조 변수에 저장
		
		emp.empNo = 1;	// 클래스의 멤버에 접근할 때 .(dot) 연산자 사용
		emp.name = "장동건";
		emp.email = "jdk@example.com";
		
		String empInfo = emp.info();
		System.out.println(empInfo);

	}

}















