
public class Ex04ControlStatement {
	
	public static void main(String[] args) {
		
		double number = Math.random(); // 0 ~ 1 사이의 난수 발생 (1은 포함되지 않습니다.)
		// System.out.println(number);
		
		number = number * 10; // 0 ~ 1 -> 0 ~ 10 사이의 난수 (실수)
		// System.out.println(number);
		
		int inumber = (int)number + 1; // 1 ~ 11 사이의 난수 (정수)
		System.out.println(inumber);
		
		// inumber가 5보다 크면 5보다 큽니다 출력
		// boolean result = inumber > 5;
		if (inumber > 5) {
			System.out.println("inumber는 5보다 큽니다.");
		} else if (inumber < 5) {
			System.out.println("inumber는 5보다 작습니다.");
		} else { // inumber == 5
			System.out.println("inumber는 5입니다.");
		}
		
		// 3의 배수 출력
		// 5의 배수 출력
		// 나머지 출력
		if (inumber % 3 == 0 && inumber % 5 == 0) {
			System.out.println("inumber는 3과 5의 공배수 입니다.");
		} else if (inumber % 3 == 0) {	// 10 % 7 -> 3 (나머지 계산)
			System.out.println("inumber 3의 배수입니다.");
		} else if (inumber % 5 == 0) {
			System.out.println("inumber는 5의 배수입니다.");
		} else {
			System.out.println("inumber는 3의 배수도 5의 배수도 아닙니다.");
		}
		
		System.out.println("끝");
		
	}

}
