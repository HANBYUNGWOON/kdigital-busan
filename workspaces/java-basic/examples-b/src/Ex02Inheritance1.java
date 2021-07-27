
class Parent {

	private int a;
	int x;
	void m() {
		System.out.println("this is parent");
	}
	
}
class Child extends Parent { // Parent를 상속하는 Child 클래스 -> Parent의 모든 멤버를 Child에 포함
	void m2() {
		x = 20;
		//a = 30; // 부모 클래스의 private 멤버는 사용할 수 없습니다.
	}
}


public class Ex02Inheritance1 {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.m();
		
		Child c = new Child();
		c.m();
	}

}
