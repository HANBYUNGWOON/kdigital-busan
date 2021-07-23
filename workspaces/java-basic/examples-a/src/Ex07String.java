
public class Ex07String {

	public static void main(String[] args) {
		
		// 변수 만들기 : 자료형 이름;
		// int a;
		String name = "John Doe"; 	// name 참조변수 만들기 + "John Doe"를 저장하는 인스턴스 만들기 + 인스턴스의 주소를 name 변수에 저장하기
									// name ---> [ 주소 ] ---> [ "John Doe" ]
		
		String phone = "010-9087-4432";	// phone ---> [ 주소 ] ---> [ "010-9087-4432" ]
		
		System.out.printf("[%s][%s]\n", name, phone);
		
		// 같은 문자열 리터럴은 여러 번 사용되어도 한 개의 인스턴스를 재사용합니다.
		String email1 = "janedoe@example.com";	// email1 ---> [ 주소 ] ---> [ "janedoe@example.com" ]
		String email2 = "janedoe@example.com";	// email2 ---> [ 주소 ] ---> 위의 인스턴스 공유
		
		// new로 만든 문자열은 내용이 같아도 항상 다른 인스턴스를 생성합니다.
		String email3 = new String("janedoe@example.com");	// email3 ---> [ 주소 ] ---> [ "janedoe@example.com" ]
		String email4 = new String("janedoe@example.com");	// email4 ---> [ 주소 ] ---> [ "janedoe@example.com" ]
		
		// 참조형에 대한 비교연산자의 동작 : 언제나 참조(주소)를 비교
		System.out.printf("email1 == email2 : %b\n", (email1 == email2) );
		System.out.printf("email3 == email4 : %b\n", email3 == email4);

		// 문자열에 대한 내용(값) 비교를 위해서는 equals 명령을 사용해야합니다.
		System.out.printf("email1 == email2 : %b\n", email1.equals(email2));
		System.out.printf("email3 == email4 : %b\n", email3.equals(email4));
		
//		int a = 1, b = 2;
//		System.out.println( a == b ); // 비교 연산자의 결과는 true or false
		
		// null : 참조 변수가 참조하는 인스턴스가 없습니다.
		String title = null; // 비교 : String title;은 쓰레기 값 저장
		
		if (title == null) { // null은 비교 연산자를 사용해서 상태를 확인할 수 있습니다.
			System.out.println("title에 아직 인스턴스가 할당되지 않았습니다.");
		}
		
		// null 상태의 변수를 사용하면 X -> NullPointerException이 발생
		System.out.println(title.equals("ceo"));
	}

}












