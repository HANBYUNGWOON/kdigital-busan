
class Parent2 {
	Parent2() {
		System.out.println("parent class constructor");
	}
	Parent2(int x) {
		System.out.println("parent class constructor 2");
	}
	Parent2(String x) {
		System.out.println("parent class constructor 3");
	}
}
class Child2 extends Parent2 { // Parent를 상속하는 Child 클래스 -> Parent의 모든 멤버를 Child에 포함
	Child2() {
		//super(); // 부모 클래스의 생성자 메서드 호출 구문이 숨겨져 있습니다.
		//super(1); // 부모 클래스의 생성자 메서드를 명시적으로, 선택해서 호출 할 수 있습니다.
		super("xyz");
		System.out.println("Child class constructor");
	}
}


public class Ex02Inheritance2 {

	public static void main(String[] args) {
		Parent2 p = new Parent2();
		System.out.println("================");
		Child2 c = new Child2(); // Child2가 만들어질때 
	}

}
