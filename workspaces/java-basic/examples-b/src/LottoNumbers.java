
public class LottoNumbers {
	
	private int[] numbers;
	
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	public LottoNumbers() {}
	public LottoNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	public String info() {
		String info = "";
		for (int number : numbers) {
			info += String.format("[%d]", number);
		}
		return info;
	}
	
	// 기본 규칙을 적용한 번호 추출 메서드
	public void generateBasicNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1; // 1 ~ 45 (45 포함)
			
			// 중복검사 비교를 위한 반복 (현재 뽑힌 숫자 위치 이전에 뽑힌 숫자와 비교)
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) { // 중복이 있는 경우
					//i = -1; // 처음부터 다시 뽑기 (위의 i++가 실행되면서 0부터 다시 뽑는 효과)
					i--; // i -= 1 or i = i - 1 // 현재 위치만 다시뽑기
					break;
				}
			}
		}
	}
	
	public int calculateMean() {
		int sum = 0;
		for (int number : numbers) {
			sum = sum + number;
		}
		int mean = sum / numbers.length;
		return mean;
	}
	
	// 평균이 정상 범위에 있는지 확인하는 메서드
	public boolean checkMean() {
		int mean = calculateMean();		
		return mean >= 20 && mean <= 26;
	}
	
	public void selectWinningNumbers() {
		do {
			generateBasicNumbers();
		} while (checkMean() == false);
	}

}



















