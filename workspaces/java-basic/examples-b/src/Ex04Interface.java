
// 인터페이스
// : 극단적인 추상 클래스
// : 모든 멤버가 추상 메서드 ( 일반 메서드롤 포함할 수 없습니다.) - 메서드에 abstract 생략 가능
// : static final 형 상수 포함할 수 있습니다.
// : 인스턴스 만들 수 없고 참조 변수에만 사용 가능
interface TheInterface {
	
	/* public static final */ int X = 1;
	
	/* public abstract */ void m();
}
interface TheInterface2 {
	/* public abstract */ void m2();
}

// 인터페이스 사용
// : 다른 클래스가 구현해서 사용
// : 인터페이스를 구현하는 클래스는 인터페이스의 모든 메서드를 구현해야 합니다. (아니면 추상클래스로 만들어야 합니다.)
// : 인터페이스 참조변수 = new 구현클래스()
class TheImplement implements TheInterface, TheInterface2 {

	@Override
	public void m() {
		System.out.println("implemented method 1");
	}
	@Override
	public void m2() {
		System.out.println("implemented method 2");
	}
	
}

public class Ex04Interface {

	public static void main(String[] args) {

		//TheInterface ti = new TheInterface(); // interface 타입은 인스턴스를 만들 수 없습니다. 
		
		TheInterface ti2 = new TheImplement();
		ti2.m();
		
	}

}
