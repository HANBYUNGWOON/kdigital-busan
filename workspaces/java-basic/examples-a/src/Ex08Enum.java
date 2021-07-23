
enum Color { 	// Color 이름의 자료형 만들기
	RED,		// Color 자료형에서 사용할 값 만들기
	ORANGE,		
	YELLOW,		
	GREEN,	
	BLUE,
	NAVY,
	PURPLE
}

public class Ex08Enum {
	
	public static void main(String[] args) {
		
		// 열거형 변수 만들기
		int x; // 4byte 정수를 저장하는 변수 만들기
		Color color; // Color 자료형에 포함된 열거 상수 중의 하나의 값을 저장할 수 있는 변수 만들기
		
		// 열거형 변수에 데이터 저장하기
		x = 110;
		color = Color.NAVY;
		
		// 비교
		if (color == Color.NAVY) {
			System.out.println("남색입니다.");
		}
		// 출력
		System.out.println(color);

	}

}
