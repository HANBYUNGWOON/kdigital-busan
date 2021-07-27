
// 추상 클래스 : 	인스턴스를 만들 수 없는 클래스 ( new 연산자 적용 X )
//				추상 메서드를 포함하는 클래스는 반드시 추상메서드로 만들어야 합니다.
abstract class TheAbstract1 {
	
	// 추상 클래스는 비추상 멤버를 포함할 수 있습니다.
	int x;
	void m2() {
		System.out.println("비추상 메서드");
	}

	// 추상 메서드 : 본문( { ... } )이 없는 메서드
	abstract void m();
	
}

// 추상 클래스 사용 : 	다른 클래스가 상속해서 사용
//					추상 클래스를 상속하는 클래스는 반드시 추상메서드를 구현해야 합니다.
//					추상클래스 참조변수 = new 구현클래스()
class TheConcrete extends TheAbstract1 {

	@Override
	void m() {
		System.out.println("재정의 메서드");
	}
	
}


public class Ex03Abstract {

	public static void main(String[] args) {
		
		//TheAbstract1 ta1 = new TheAbstract1(); // 오류 : 추상클래스의 인스턴스 생성 X
		
		TheAbstract1 ta2 = new TheConcrete();
		ta2.m();

	}

}
