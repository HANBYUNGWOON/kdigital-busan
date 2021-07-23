
public class Ex09Method3 {

	public static void main(String[] args) {
		
		// 함수 호출
		int result = add(10, 20);
		
		System.out.printf("10 + 20 = %d\n", result);
		
		f();

	}
	
	// 함수 정의
	private static int add(int n1, int n2) {
		
		int result = n1 + n2;
		
		return result; 	// 1. 함수 종료 + 2. ( 데이터를 가지고 ) 호출한 곳으로 돌아가기	
						// return 을 통해 값을 반환하는 메서드는 반드시 선언부에 반환 자료형을 표시해야 합니다. 
	}	
	
	private static void f() {	// return type void : 이 메서드는 반환하는 값이 없습니다.
		
	}

}
