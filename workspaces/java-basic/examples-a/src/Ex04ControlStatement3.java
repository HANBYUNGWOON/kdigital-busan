
public class Ex04ControlStatement3 {

	public static void main(String[] args) {
		
		// 가위바위보 게임
		// 1. 컴퓨터 변수에 1, 2, 3 중의 하나를 저장
		int com = (int)( Math.random() * 3 ) + 1; // 1, 2, 3		
		// 테스트 코드 : 컴퓨터 변수 값 출력
		// System.out.println(com);
		
		// 2. 사용자 변수 만들고 사용자 입력을 받아서 변수에 저장 (1, 2, 3 중의 하나)
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("가위(1) 바위(2) 보(3)를 선택하세요 : ");
		int yours = scanner.nextInt();
		// 테스트 코드 : 사용자 입력 값 출력
		// System.out.println(yours);
		
		//==================================================
		
		// 3. 승부 결정 (1: 가위, 2: 바위, 3: 보)
		// 4. 결과 출력
		if (com == yours) {
			System.out.println("비겼습니다.");
		} else if (yours == 1 && com == 3) { // 사용자 == 1 그리고 컴퓨터 == 3
			System.out.println("이겼습니다.");
		} else if (yours == 2 && com == 1) { // 사용자 == 2 그리고 컴퓨터 == 1
			System.out.println("이겼습니다.");
		} else if (yours == 3 && com == 2) { // 사용자 == 1 그리고 컴퓨터 == 3
			System.out.println("이겼습니다.");
		} else {
			System.out.println("졌습니다.");
		}
		
		System.out.println("=============================");
		
		if (com == yours) {
			System.out.println("비겼습니다.");
		} else if ( (yours == 1 && com == 3) || 
					(yours == 2 && com == 1) || 
					(yours == 3 && com == 2) ) {
			System.out.println("이겼습니다.");
		} else {
			System.out.println("졌습니다.");
		}
		
		System.out.print("컴퓨터 : ");
		switch (com) {
		case 1: System.out.println("가위"); break;
		case 2: System.out.println("바위"); break;
		case 3: System.out.println("보"); break;
		}
		System.out.print("사용자 : ");
		switch (yours) {
		case 1: System.out.println("가위"); break;
		case 2: System.out.println("바위"); break;
		case 3: System.out.println("보"); break;
		}
		

	}

}















