
public class Ex09Method5 {

	public static void main(String[] args) {
		
		int result = add(10, 20);
		System.out.println(result);
		
		result = add(10, 20, 30);
		System.out.println(result);
		
		result = add(10, 20, 30, 40);
		System.out.println(result);

	}
	
	// 메서드는 이름과 전달인자의 자료형, 갯수, 순서를 반영해서 구분
	static int add(int n1, int n2) {
		return n1 + n2;
	}
	static int add(int n1, int n2, int n3) {
		return n1 + n2 + n3;
	}
	static int add(int n1, int n2, int n3, int n4) {
		return n1 + n2 + n3 + n4;
	}
	


}
