import java.util.Scanner;

public class LottoManager {
	
	Scanner scanner = new Scanner(System.in);
	LottoNumbers lotto = new LottoNumbers();
	
	public void doManage() {
		outer: while (true) {
			String selection = selectMenu();
			
			switch (selection) {
			case "1": // 번호 뽑기
				lotto.selectWinningNumbers();
				System.out.print("[ 당첨 예상 번호 ] : ");
				System.out.println(lotto.info());
				break;
				
			case "9": // 종료
				System.out.println("행운을 빕니다. 부자되세요 !!!");
				break outer;
				
			default: // 위의 case로 제어하지 않은 나머지 모든 경우
				System.out.println("지원하지 않는 기능입니다.");
				break;	
			}
		}
	}
	
	private String selectMenu() {
		System.out.println("****************************");
		System.out.println("* 1. 당첨 예상 번호 뽑기.");
		System.out.println("* 9. 종료.");
		System.out.println("****************************");
		System.out.print("작업 번호를 입력하세요 : ");
		String selection = scanner.nextLine();
		return selection;
	}
	
	public static void main(String[] args) {
		LottoManager manager = new LottoManager();
		manager.doManage();
	}

}















