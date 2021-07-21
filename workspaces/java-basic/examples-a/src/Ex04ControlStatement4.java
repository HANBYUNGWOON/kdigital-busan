
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

	}

}
















