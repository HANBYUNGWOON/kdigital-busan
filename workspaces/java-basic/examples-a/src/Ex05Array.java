
public class Ex05Array {

	public static void main(String[] args) {
		
		//배열
		// - 같은 자료형의 데이터 관리
		// - 만들 때 크기 지정
		// - 참조형
		// - 배열 요소의 자료형은 모든 자료형이 가능 ( 다른 배열을 요소로 하는 배열도 가능 )
		
		//1. 배열 만들기
		//   int : 자료형, int[] : 자료형
		int[] ar1; // 참조변수 만들기 
		ar1 = new int[10]; // 값이 저장되는 변수 (인스턴스 / 객체)를 만들고 그 변수의 주소를 ar1 참조변수에 저장
		
		int[] ar2 = new int[10];// 값이 저장되는 변수와 참조 변수를 만들고 값이 저장되는 변수의 주소를 참조변수에 저장
		
		//2. 배열 사용하기1
		ar1[0] = 10;
		ar1[3] = 20;
		System.out.printf("%d - %d\n", ar1[0], ar1[3]);
		
		System.out.println("==========================");
		
		//3. 배열 사용하기 2
		for(int i = 0; i < 10; i++) {
			ar2[i] = (int)(Math.random() * 900) + 100; // 100 ~ 1000 (1000은 포함하지 않습니다)
		}
		for (int i = 0; i < 10; i++) {
			System.out.printf("ar2[%d] = %d\n", i, ar2[i]);
		}
		
		System.out.println("==========================");
		
		//4. 배열 초기화
		int a;		// 선언
		a = 10; 	// 할당, 대입
		int b = 20;	// 초기화 (변수를 만들면서 즉시 특정한 값을 저장)
		
		//int[] ar4 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int[] ar4 = { 10, 20, 30, 40 };
		for (int i = 0; i < ar4.length; i++) { // 배열.length : 배열의 요소 갯수 반환
			System.out.println(ar4[i]);
		}
		
		//5. 다차원 배열
		// - 배열 요소의 자료형은 모든 자료형이 가능 ( 다른 배열을 요소로 하는 배열도 가능 )
		
		int[][] ar5 = new int[3][7];
		
		// 배열에 값 저장
		for (int i = 0; i < ar5.length; i++) {
			for (int j = 0; j < ar5[i].length; j++) { // ar5[i].length == 7
				ar5[i][j] = (int)(Math.random() * 900) + 100; // 100 ~ 1000 (1000은 포함하지 않습니다)
			}
		}
		
		// 배열에 저장된 값 읽기 및 출력
		for (int i = 0; i < ar5.length; i++) {
			for (int j = 0; j < ar5[i].length; j++) {
				System.out.printf("[%5d]", ar5[i][j]);
			}
			System.out.println();
		}

		//6. 다차원 배열 초기화
		int[][] ar6 = {{1, 2, 3}, 
					   {4, 5, 6}};
		for (int i = 0; i < ar6.length; i++) {
			for (int j = 0; j < ar6[i].length; j++) {
				System.out.printf("[%5d]", ar6[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("========================");
		//7. 향상된 for
		int[] ar7 = { 15, 43, 67, 45, 27, 98, 65 };
//		for (int i = 0; i < ar7.length; i++) {
//			int n = ar7[i];
//			System.out.println(n);
//		}
		for (int n : ar7) {// ar7 배열의 각 요소를 순차적으로 읽어서 n 변수에 저장하고 실행을 반복
			System.out.println(n);
		}
		
	}

}










