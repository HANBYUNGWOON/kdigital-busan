
class Constants {
	
	// 변수 : 값을 변경할 수 있는 메모리의 공간
	// 상수 : 값을 변경할 수 없는 메모리의 공간
	
	int x1;
	final int x2 = 100;
	static final int x3 = 300; // static final은 반드시 필드 초기화를 수행해야 합니다.
	
	public Constants() {
		x1 = 100; 
		// x2 = 200;	// final field는 생성자에서 값 저장 가능 (필드 초기화를 한 경우 오류)
		// x3 = 300;	// static final field는 생성자에서 값 저정 가능
	}
	
	void m() {
		x1 = 10;
		// x2 = 20; // final field 의 값을 변경할 수 없습니다.
		// x3 = 30;	// static final field 의 값을 변경할 수 없습니다.
	}
	
}


public class Ex01OOP5 {

	
	
	public static void main(String[] args) {
		
		

	}

}















