
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

}
