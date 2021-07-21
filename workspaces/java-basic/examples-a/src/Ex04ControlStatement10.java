
public class Ex04ControlStatement10 {

	public static void main(String[] args) {
		
		//구구단 출력
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		String yn = "";
		do {
			//1. 사용자에게 출력할 단을 숫자로 입력(1 ~ 9)받아서 변수에 저장
			System.out.print("출력할 구구단의 단을 입력하세요 (1 ~ 9) : ");
			int dan = scanner.nextInt();
			
			//2. 해당 단의 구구단을 출력
			for (int i = 1; i < 10; i++) {
				// %5d : 숫자를 5칸에 출력 ( 오른쪽 정렬 )
				System.out.printf("%d * %d = %2d\n", dan, i, dan * i);
			}
			
			System.out.print("계속할까요(y/n)?");
			yn = scanner.next();
		} while (yn.equalsIgnoreCase("y"));
		

	}

}
