import java.util.Scanner;

import a.b.B; // 이후의 코드에서 B클래스를 사용하면 a.b.B 클래스임을 선언

public class Ex01OOP6 {
	
	public static void main(String[] args) {
		
		// 다른 클래스를 사용할 때 클래스 이름은 패키지명까지 모두 표시해야 합니다.
		// B b = new B();
		a.b.B b = new a.b.B();
		
		// 패키지명을 생략할 수 있습니다. : import 구문을 사용하면 
		B b2 = new B();
		
		//
		java.util.Scanner s = new java.util.Scanner(System.in);
		Scanner s2 = new Scanner(System.in);

	}

}















