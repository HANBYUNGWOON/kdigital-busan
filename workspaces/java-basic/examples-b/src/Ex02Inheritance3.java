
class Parent3 {
	int x;
	void m() {
		System.out.println("Parent3.m() is called");
	}
}
class Child3 extends Parent3 {
	// 상속을 받은 클래스는 확장 또는 변경의 내용을 포함해야 합니다.
	
	int y; // 확장 : 새로운 멤버 추가
	
	// 변경 : 부모 클래스의 메서드를 수정 ( 부모 클래스의 메서드 형태는 그대로 유지하면서 내용만 수정 )
	// 메서드 재정의 (Method Overriding)
	void m() {
		super.m(); //super : 부모 클래스의 멤버를 명시적으로 지정
		System.out.println("Modified Child3.m() is called");
	}
}
public class Ex02Inheritance3 {

	public static void main(String[] args) {
		
		Parent3 p = new Parent3();
		p.m(); // Parent3에 정의된 m() 호출
		System.out.println("================");
		Child3 c = new Child3();
		c.m(); // Child3에 재정의된 m() 호출
		
	}

}






