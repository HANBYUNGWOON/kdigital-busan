import java.util.Scanner;

public class Ex04ControlStatement4 {

	public static void main(String[] args) {

		int round = 1;
		while ( round <= 10 ) {
			System.out.println("ROUND : " + round);
			// round = round + 1;
			// round += 1; // round = round + 1
			// round++; // round = round + 1, ++round
			++round;
		}
		
		System.out.println("==============================");
		
		int round2 = 1;
		do {
			System.out.println("ROUND2 : " + round2);
			round2++;
		} while (round2 <= 10);
		
		System.out.println("==============================");
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		int input = -1;
		do {
			System.out.println("숫자 1, 2, 3 중 하나를 입력하세요 : ");
			input = scanner.nextInt();
		} while (input < 1 || input > 3);
		System.out.println("INPUT : " + input);
		
		// while ( 1 < input < 3 )
		// 1 < input < 3
		// ( 1 < input ) < 3
		// true or false < 3
		
		System.out.println("==============================");
		
		for (int round3 = 1; round3 <= 10; round3++) {
			System.out.println("ROUND3 : " + round3);
		}
		
		System.out.println("==============================");
		
		int round3 = 1;
		for ( ; round3 <= 10 ; ) {
			System.out.println("ROUND3 : " + round3);
			round3++;
		}
		
		///////////////////
		
		// 사용자 정수 입력 -> 1 ~ 입력된 숫자까지 정수 합 구하기
		System.out.print("1부터 합을 구할 숫자를 입력하세요 : ");
		int number = scanner.nextInt();
		int sum = 0;
		for (int i = 1; i <= number; i++) { // i++ -> i = i + 1
			sum = sum + i;
		}
		System.out.printf("1 ~ %d까지의 합 : %d\n", number, sum);
		
		///////////////////
		
		// **********
		// *********
		// ********
		// ..
		// *

	}

}
















