
public class Ex09Method {

	public static void main(String[] args) {
		
		// 메서드 호출 : 만들어진 메서드를 실행하게 만드는 코드
		drawBox();

	}

	// 메서드 정의 : 코드 블럭을 관리하는 메서드를 만드는 구현
	private static void drawBox() {
		
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 20; x++) {
				//조건에따라
				if (y == 0 || y == 9 || x == 0 || x == 19) {
					System.out.print("#");
				} else {				
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	

}
