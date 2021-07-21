
public class Ex04ControlStatement9 {

	public static void main(String[] args) {
		
		// 성적처리 프로그램
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String yn = "";
		do {
			// 1. 점수입력 + 변수에 저장 (score1)
			int score1 = 0;
			do {
				System.out.print("첫 번째 점수(0 ~ 100)를 입력하세요 : ");
				score1 = scanner.nextInt();
			} while (score1 < 0 || score1 > 100);
			// 2. 점수입력 + 변수에 저장 (score2)
			System.out.print("두 번째 점수를 입력하세요 : ");
			int score2 = scanner.nextInt();
			// 3. 점수입력 + 변수에 저장 (score3)
			System.out.print("세 번째 점수를 입력하세요 : ");
			int score3 = scanner.nextInt();
			
			// 테스트코드
			// System.out.printf("%d, %d, %d\n", score1, score2, score3);
			
			// 4. 점수 합계 구하기 + 변수에 저장 (total)
			int total = score1 + score2 + score3;		
			// 5. 평균 구하기 + 변수에 저장 (mean)
			double mean = total / 3.;
			
			// 테스트코드
			// System.out.printf("%d, %f\n", total, mean);
			
			// 6. 등급 구하기 + 변수에 저장
			String grade = "";
			switch ((int)mean / 10) {
			case 10: 
			case 9:  grade = "A"; break;
			case 8:  grade = "B"; break;
			case 7:  grade = "C"; break;
			case 6:  grade = "D"; break;
			default:  grade = "F"; break;
			}
			
			//7. 결과 출력
			System.out.printf("[TOTAL : %d][MEAN : %.2f][GRADE : %s]\n", total, mean, grade);
		
			//8. 계속 여부 확인
			System.out.print("계속할까요(y/n) : ");
			yn = scanner.next();
		//} while (yn.equals("y") || yn.equals("Y"));
		} while (yn.equalsIgnoreCase("y"));

	}

}
