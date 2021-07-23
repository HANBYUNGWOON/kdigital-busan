
public class Ex09Method2 {

	public static void main(String[] args) {
		
		// 중괄호는 영역을 만듭니다. : 중괄호 내부에서 만들어진 변수는 그 중괄호 안에서만 사용할 수 있습니다. 
		{
			int x = 10;
			x = 20; // 영역 내에서 사용 가능			
		}
		// x = 20; // 오류 : 영역 밖에서 사용하는 것은 불가능
		
		///////////////////////////////////////////////////////////////////////////////
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		//1. 사용자가 입력한 문자로 박스 그리기
		System.out.print("박스 그리기에 사용할 문자 : ");
		String s = scanner.next();
		
		//2. 사용자가 입력한 너비와 높이를 사용해서 박스 그리기
		System.out.print("박스의 너비 : ");
		int width = scanner.nextInt();
		System.out.print("박스의 높이 : ");
		int height = scanner.nextInt();
		
		// 메서드 호출 : 만들어진 메서드를 실행하게 만드는 코드
		drawBox(s, width, height);

	}

	// 메서드 정의 : 코드 블럭을 관리하는 메서드를 만드는 구현
	private static void drawBox(String s, int width, int height) {
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//조건에따라
				if (y == 0 || y == height - 1 || x == 0 || x == width - 1) {
					System.out.print(s); // 사용자가 입력한 문자로 그리기
				} else {				
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	

}
