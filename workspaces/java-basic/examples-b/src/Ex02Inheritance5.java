
class Shape {
	void draw() {
		System.out.println("draw shape");
	}
}

class Line extends Shape {
	//@Annotation : 컴파일러에게 주는 코드에 대한 설명 -> 컴파일러는 적절한 추가 코드 적용
	@Override // 이 메서드가 재정의 메서드라는 것을 표시
	void draw() {
		System.out.println("draw line");
	}
}
class Oval extends Shape {
	void draw() {
		System.out.println("draw oval");
	}
}
class Rect extends Shape {
	void draw() {
		System.out.println("draw rect");
	}
}

public class Ex02Inheritance5 {

	public static void main(String[] args) {
		
		// 다형성 테스트
		
		//1. Line 3개, Oval 3개, Rect 4개를 만들어서 관리
		//2. 여러개이므로 배열에 담도록 구현 
		//   -> 배열은 같은 자료형의 데이터만 저장할 수 있기 때문에 여러 개의 배열을 만들어야 하는 문제 발생
		//3. Line, Oval, Rect를 하나의 배열에 담는 방법은?
		
		Shape[] shapes = new Shape[10]; // Shape은 Line, Oval, Rect의 부모 클래스이므로 Shape 배열에는 Line, Oval, Rect를 저장할 수 있습니다.
		for (int i = 0; i < shapes.length; i++) {
			if (i % 3 == 0) {
				shapes[i] = new Rect();
			} else if (i % 3 == 1) {
				shapes[i] = new Line();
			} else {
				shapes[i] = new Oval();
			}
		}
		
		for (Shape shape : shapes) {
			shape.draw(); // 동일한 코드가 인스턴스에 따라 다른 동작을 수행 -> 다형성 (Polymorphism)
		}
		
		System.out.println("===============================");
		
		Rect r = new Rect();
		doDraw(r);
		
		Line l = new Line();
		doDraw(l);
		
		//////////////////////////////////////////
		
		Shape sx1 = new Shape();
		Shape sx2 = new Rect();
		
		if (sx1 instanceof Rect) { // a instanceof B : a를 B로 형변환 할 수 있는지 확인
			Rect rx1 = (Rect)sx1;
		}
		if (sx2 instanceof Rect) {
			Rect rx2 = (Rect)sx2;
		}
		

	}
	
//	static void doDraw(Rect r) {
//		r.draw();
//	}
//	static void doDraw(Line l) {
//		l.draw();
//	}
	static void doDraw(Shape s) {
		s.draw();
	}

}












