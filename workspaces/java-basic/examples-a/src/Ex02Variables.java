
public class Ex02Variables {

	public static void main(String[] args) {
		
		//1. 변수 만들기 ( 자료형 이름 )
		int number; // int 자료형, number 이름을 가진 변수 만들기
		number = 10; // 변수에 값을 저장
		System.out.println("Number : " + number); // 변수의 값 읽기
		
		//2. 변수 초기화
		double height = 185.4; // 변수 선언(만들기) + 값 저장
		
		//3. 초기화하지 않은 변수는 사용할 수 없습니다.
		int age;
		//System.out.println(age); // 오류
		
		
		//4. 변수의 영역
		{ // 영역 생성
			int x = 20; // 특정 영역에서 만들어진 변수는 그 영역 + 하위 영역에서만 사용 가능
			x = 30;
			{
				x = 40;
			}
		
		}
		
		//x = 40; // 다른 영역의 변수는 사용할 수 없습니다.

		//5. 자료형
		boolean b;
		b = true;
		b = false;
		System.out.println(b);
		
		//6. 리터럴 : 코드에 사용된 값 표현 --> 10, 11.11, true
		int color = 0xfefefe;
		System.out.println(color);
		
		//7. char 자료형
		int A = 10;
		char c = 'A'; // 문자 리터럴은 '를 사용해서 표현
		System.out.println("문자표현 : " + c);
		System.out.println("숫자표현 : " + (int)c); // (자료형)변수 : 변수를 지정된 자료형으로 변경
		
		//8. 문자열 자료형
		String name = "John Doe"; // 문자열 리터럴은 " 사용
		System.out.println(name);
		
		//9. Escape Sequence
		String message = "안녕하세요 \"홍길동\"님. \n만나서 반갑습니다.";
		System.out.println(message);
		
		//10. 형변환 (Type Casting)
		double d = 10; // --> 10.0으로 변경 ( 데이터 손실이 없으면 암시적 형변환 )
		int x = (int)11.11; // --> 11로 변경 ( 데이터 손실이 발생하면 명시적 형변환 )
		String s = "value 1 : " + d + " / value 2 : " + x; // d와 x를 문자열로 형변환
		// int y = (int)"100"; // 문자열을 숫자로 직접 형변환 할 수 없습니다.
		int y = Integer.valueOf("100"); // 문자열을 정수로 변환
		int y2 = Integer.parseInt("100"); // 문자열을 정수로 변환
		
		System.out.println(s);
		System.out.println(y);
		System.out.println(y2);
		
		
		
	}

}
