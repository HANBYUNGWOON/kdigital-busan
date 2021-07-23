
public class Ex06Lotto {

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		outer : while (true) { // 무한 반복
			
			System.out.println("****************************");
			System.out.println("* 1. 당첨 예상 번호 뽑기.");
			System.out.println("* 9. 종료.");
			System.out.println("****************************");
			System.out.print("작업 번호를 입력하세요 : ");
			String selection = scanner.nextLine();
			
			System.out.println();
			
			// 뽑힌 숫자를 저장할 변수
			int[] numbers = new int[6];
			int mean = 0, sum = 0;
			
			switch (selection) {
			case "1":
				do {
					// 1. 기본 규칙을 적용한 숫자를 뽑아서 배열 변수에 저장
					for (int i = 0; i < numbers.length; i++) {
						numbers[i] = (int)(Math.random() * 45) + 1; // 1 ~ 45 (45 포함)
						
						// 중복검사 비교를 위한 반복 (현재 뽑힌 숫자 위치 이전에 뽑힌 숫자와 비교)
						for (int j = 0; j < i; j++) {
							if (numbers[i] == numbers[j]) { // 중복이 있는 경우
								//i = -1; // 처음부터 다시 뽑기 (위의 i++가 실행되면서 0부터 다시 뽑는 효과)
								i--; // i -= 1 or i = i - 1 // 현재 위치만 다시뽑기
								break;
							}
						}
					}
					
					// 2. 평균 구하기
					sum = 0;
					for (int number : numbers) {
						sum = sum + number;
					}
					mean = sum / numbers.length;
				} while (mean < 20 || mean > 26); // 평균이 20보다 작거나 26보다 크다면 다시 뽑기
				
				// 뽑힌 숫자 출력
				System.out.print("[ 당첨 예상 번호 ] : ");
				for (int number : numbers) {
					System.out.printf("[%2d]", number);
				}
				System.out.printf("[MEAN : %2d]", mean);
				System.out.println();
				break;
			case "9": // 종료
				System.out.println("행운을 빕니다. 부자되세요 !!!");
				break outer;
				
			default: // 위의 case로 제어하지 않은 나머지 모든 경우
				System.out.println("지원하지 않는 기능입니다.");
				break;
				
			}
			
			System.out.println();
			
		}
//		1. 기본 규칙을 적용한 숫자를 뽑아서 배열 변수에 저장
//		   1 ~ 45 사이의 숫자, 
//		   중복 X, 
//		   Random,  // Math.random()
//		   6개
		
		// 테스트코드 (출력)

	}

}
