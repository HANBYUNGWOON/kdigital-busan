import java.util.Scanner;

class MyClass extends Object {
	
	int x;
	
	@Override
	public boolean equals(Object obj) {
		MyClass other = (MyClass)obj;
		return this.x == other.x;
	}
	
	@Override
	public String toString() {
		return String.format("[X : %d]", x);
	}
}
public class Ex01Object {

	public static void main(String[] args) {

		MyClass mc1 = new MyClass();
		mc1.x = 1;
		
		MyClass mc2 = new MyClass();
		mc2.x = 1;
		
		System.out.println(mc1 == mc2);
		System.out.println(mc1.equals(mc2)); // Object.equals() 기본 구현은 참조 비교
		
		//////////////////////////
		
		System.out.println(mc1);	// 문자열이 필요한 곳에서 자동으로 객체의 toString() 메서드 호출
		
		
		//////////////////////////
		
		// Object 형식의 참조 변수는 모든 인스턴스를 참조할 수 있습니다.
		Object obj = "Hello";
		obj = new MyClass();
		obj = new Scanner(System.in);
		
		//////////////////////////
		
	}

}
