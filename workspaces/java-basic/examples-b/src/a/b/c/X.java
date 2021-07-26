package a.b.c;

import a.b.c2.Z;

public class X {
	
	void test() {
		Z z = new Z();
		z.f1 = 10;
		// z.f2 = 20; // 다른 패키지의 default 멤버 사용할 수 없습니다.
	}

}
