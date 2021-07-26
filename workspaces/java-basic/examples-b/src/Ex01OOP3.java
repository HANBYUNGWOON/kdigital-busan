
// class : 구현 대상을 문법접으로 표현
//         사용자 정의 자료형 ( 참조형 )
class Employee3 {
	
	public int empNo = 10;
	public String name = "No Name";
	public String email = "Unknown";	
	
	// 생성자 메서드 (constructor)
	// 1. 이름이 클래스 이름과 일치
	// 2. 결과형 표시 X
	// 3. new를 사용해서 인스턴스를 만들 때 자동으로 호출
	// 4. 오버로딩 가능 : 전달인자의 조합을 변경해서 여러 개의 생성자 메서드 만들 수 있습니다.
	
	// public Employee3() {} --> 생성자 메서드를 만들지 않으면 기본 생성자 메서드가 생략되어 있음
	public Employee3() {
		System.out.println("전달인자 없는 생성자 메서드...");
	}	
	public Employee3(int empNo, String name, String email) {
		this(); // 같은 클래스의 전달인자 없는 생성자 메서드 호출하는 구문 ( 생성자 메서드의 첫 번째 구문이어야 합니다. )
		System.out.println("전달인자 3개인 생성자 메서드 ....");
		this.empNo = empNo; // 전달인자 empNo의 값을 클래스의 멤버 empNo에 저장
		this.name = name;
		this.email = email;
	}

	//public : 외부에서 자유롭게 접근할 수 있는 멤버
	public String info() {
		//String.format : System.out.printf 과 동일한 형식으로 사용하되 문자열만 만들고 출력 기능은 빠진 메서드
		String info = String.format("[%d][%s][%s]", empNo, name, email);
		return info;
	}
}
public class Ex01OOP3 {

	public static void main(String[] args) {
		
		int x;
		x = 10;
		int y = 10; // 변수 초기화 ( 변수를 만들면서 어떤 값을 저장 )
		
		int[] ar = { 1, 2, 3 }; // 배열 초기화 ( 배열을 만들면서 어떤 값을 저장 )
				
		// 클래스 사용 : 클래스 타입의 변수 만들기 + 데이터 저장/읽기 + 기능 호출
		Employee3 emp;			// 참조 변수 만들기		
		emp = new Employee3();	// 전달인자 없는 생성자 메서드 호출 ( new Employee3() : 생성자 호출 구문 )
		
		Employee3 emp2;
		emp2 = new Employee3(2, "송강호", "skh@example.com"); // 전달인자 3개인 생성자 메서드 호출
		
		String empInfo = emp2.info();
		System.out.println(empInfo);

	}

}















