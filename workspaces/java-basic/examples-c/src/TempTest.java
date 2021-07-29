import java.util.Arrays;

public class TempTest {

	public static void main(String[] args) {
		
		int [] ar = { 4, 7, 1, 10, 6, 3 };
		for (int n : ar) {
			System.out.printf("[%3d]", n);
		}
		System.out.println();
		
		Arrays.sort(ar);
		
		for (int n : ar) {
			System.out.printf("[%3d]", n);
		}
		System.out.println();

	}

}
