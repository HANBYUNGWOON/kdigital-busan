
public class Ex04ControlStatement7 {

	public static void main(String[] args) {
		
		// 계산기 만들기
		
		// 사용자 입력을 위한 입력기 변수 만들기
		java.util.Scanner scanner = new java.util.Scanner(System.in);		
		// 1. 숫자 입력
		System.out.print("숫자를 입력하세요 : ");
		int operand1 = scanner.nextInt();
		// 2. 연산자 입력 ( +, -, *, /, % )
		System.out.print("연산자(+, -, *, /, %)를 입력하세요 : ");
		String op = scanner.next(); // next(), nextLine() 입력을 문자열로 변환		
		// 3. 숫자 입력
		System.out.print("숫자를 입력하세요 : ");
		int operand2 = scanner.nextInt();		
		double result = 0;	// 연산 결과를 저장할 변수
		boolean valid = true; // 연산자의 유효 여부를 저장할 변수
		// 4. 사용자가 입력한 연산자에 따라 연산 수행
		switch (op) {
		case "+":
			result = operand1 + operand2;
			break;
		case "-":
			result = operand1 - operand2;
			break;
		case "*":
			result = operand1 * operand2;
			break;
		case "/":
			result = (double)operand1 / operand2;
			break;
		case "%":
			result = operand1 % operand2;
			break;
		default:
			valid = false;
			break;
		}
		// 5. 연산 결과 출력
		if (valid) {
			System.out.printf("%d %s %d = %.2f\n", operand1, op, operand2, result);
		} else {
			System.out.println("지원하지 않는 연산자입니다.");
		}
	}

}

// 같은 자료형의 데이터 연산 결과는 피연산 변수의 자료형과 같습니다. : int 연산 int -> 결과도 int
// 다른 자료형의 데이터 연산 결과는 범위가 넓은 피연산 변수의 자료형과 같습니다. : int 연산 double -> 결과는 double










