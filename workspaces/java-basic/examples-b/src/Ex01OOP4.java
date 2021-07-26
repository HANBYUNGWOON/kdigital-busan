
// class : 구현 대상을 문법접으로 표현
//         사용자 정의 자료형 ( 참조형 )
class Employee4 {
	
	// static
	// 1. 공유 멤버 (메서드와 필드에 모두 적용 가능)
	// 2. 참조 변수로 접근하지 않고 클래스 이름으로 접근
	public static String author;
	public static void staticMethod() {
		System.out.println("Static Method");
		//static 메서드 영역에서 instance 멤버 사용할 수 없습니다. (this 포함)
		//empNo = 100; // 오류
	}
	
	public int empNo;
	public String name;
	public String email;	
	
	//public : 외부에서 자유롭게 접근할 수 있는 멤버
	public String info() {
		//String.format : System.out.printf 과 동일한 형식으로 사용하되 문자열만 만들고 출력 기능은 빠진 메서드
		String info = String.format("[%d][%s][%s]", empNo, name, email);
		return info;
	}
}
public class Ex01OOP4 {

	public static void main(String[] args) {
		
//		Employee4 e1 = new Employee4();
//		e1.name = "John Doe";
//		Employee4 e2 = new Employee4();
//		e2.name = "Jane Doe";
//		
//		System.out.println(e1.info());
//		System.out.println(e2.info());
//		
//		e1.author = "홍길동";
//		e2.author = "김윤석";
//		System.out.println(e1.author);
		//static 멤버는 인스턴스 참조 변수가 아니라 클래스 이름으로 접급하는 것이 좋습니다.
		System.out.println(Employee4.author);
		
		System.out.println("======================");
		
		System.out.println(Math.random());
	}

}















