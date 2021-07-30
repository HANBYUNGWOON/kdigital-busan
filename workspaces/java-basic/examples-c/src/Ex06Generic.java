import java.util.Date;

class TheObject {
	Object v; // 모든 자료형의 데이터를 저장할 수 있는 변수
}

class TheGeneric<T, E> { // T, E : 미확정 타입 -> 이 클래스를 사용하는 시점에 결정
	T v;
	E v2;
	E m(T t) {
		return null;
	}
}
// TheGeneric<Integer, String>으로 사용했을 때 자동으로 생성되는 클래스
//class TheGeneric {
//	Integer v;
//	String v2;
//	
//	String m(Integer t) {
//		return null;
//	}
//}

public class Ex06Generic {

	public static void main(String[] args) {

		TheObject obj1 = new TheObject();
		obj1.v = 10;
		TheObject obj2 = new TheObject();
		obj2.v = "홍길동";
		
		int x = (int)obj1.v;
		if (obj2.v instanceof Integer) {
			int x2 = (int)obj2.v;
		}
		
		////////////////////////////////////
		
		TheGeneric<Integer, String> obj3 = new TheGeneric<>();
		obj3.v = 10;
		obj3.v2 = "문자열데이터";
		TheGeneric<String, Date> obj4 = new TheGeneric<>();
		obj4.v = "장동건";
		
		int x2 = obj3.v;	//Generic 형식에서 데이터를 읽을 경우 형변환이 필요 없습니다.
		//int s2 = (int)obj4.v;	//오류 있는 형변환을 미리 검출
		String s2 = obj4.v;
		
		System.out.println("End of program");

	}

}












