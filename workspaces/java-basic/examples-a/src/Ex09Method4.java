
public class Ex09Method4 {

	public static void main(String[] args) {
		
		int result = add(10, 20, 30);
		System.out.println(result);
		
		result = add(10, 20, 30, 40, 50);
		System.out.println(result);
		
		result = add(10, 20, 30, 40, 50, 70, 30, 40, 100);
		System.out.println(result);

	}
	
	static int add(int ... numbers) { // 전달인자의 ...은 갯수와 상관없이 전달인자 받기 -> 전달인자의 형식은 배열
		int sum = 0;
		for (int n : numbers) {
			sum += n;
		}
		return sum;
	}
	
//	static int add(int n1, int n2) {
//		
//		return n1 + n2;
//	}
//	static int add3(int n1, int n2, int n3) {
//		
//		return n1 + n2 + n3;
//	}

}
