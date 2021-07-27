
class Parent4 {
	int x;
	void m() {
		System.out.println("parent4.m");
	}
}
class Child4 extends Parent4 {
	int y;
	void m() {
		System.out.println("child4.m");
	}
}
public class Ex02Inheritance4 {

	public static void main(String[] args) {
		
		Parent4 p = new Parent4();
		Child4 c = new Child4();
		
		// 상속 관계의 클래스에서 참조변수의 자료형과 인스턴스의 자료형이 다를 수 있습니다.
		// 부모 타입의 참조 변수로 자식 타입의 인스턴스 참조하는 것은 언제나 가능 (자동 형변환)
		// 자식 타입의 참조 변수로 부모 타입의 인스턴스 참조하는 것은 언제나 불가능 (명시적 형변환 필요)
		Parent4 p2 = c; 		// 왼쪽 코드는 결과적으로 오른쪽과 같습니다 : Parent4 p2 = new Child4()
		// Child4 c2 = (Child4)p;  // 왼쪽 코드는 결과적으로 오른쪽과 같습니다 : Child4 c2 = (Child4)new Parent4()
		
		Child4 c3 = (Child4)p2; // 이 코드는 Child4 c3 = new Child4()
		
		/////////////////////////////////////////////////////////////////
		
		Parent4 p4 = new Child4(); // 참조변수의 자료형과 인스턴스의 자료형이 다를 때
		p4.m(); //재정의된 메서드를 호출하면... 항상 인스턴스 타입을 따라 메서드를 호출합니다.
		
		System.out.println("End of program !!!");
		
	}

}






