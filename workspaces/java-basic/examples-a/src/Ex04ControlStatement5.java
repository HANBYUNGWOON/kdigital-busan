
public class Ex04ControlStatement5 {

	public static void main(String[] args) {
		
		// 1에서 20까지 1씩 증가하면서 출력
		// 홀수만 출력
		// 15가 되면 반복문 종료 -> break
		
		for (int i = 1; i <= 20; i++) { // i -> 1, 2, 3, ... 20
			if (i % 2 == 0) { // 짝수 조건
				continue; // 반복문의 시작위치로 즉시 이동 (이후에 나오는 반복 영역의 실행문을 실행하지 마세요)
			}
			if (i == 15) {
				break; // 반복문을 즉시 종료
			}
			
			System.out.println("현재 순서 번호 : " + i);
			
		}
		
		System.out.println("=======================");
		
		outer1 : for (int i = 0; i < 10; i++) {
			switch (i) { 
			case 5:
				// break; // switch 종료
				break outer1; // outer1 이름이 붙은 반복문 또는 switch 문 종료
			}
			
			System.out.println("i1 : " + i);
		}
		
		System.out.println("=======================");
		
		outer2 : for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				if ( j == 3 ) {
					//break; // j 반복문 종료
					break outer2; // outer 이름이 붙은 반복문 또는 switch 문 종료
				}
				System.out.println("j : " + j);
			}
			System.out.println("i2 : " + i);
		}

	}

}

// % 연산자 : 나머지를 계산하는 연산자
// 10 % 3 -> 1
// 10 % 2 -> 0
// 10 % 7 -> 3
