
public class Ex04ControlStatement4_1 {

	public static void main(String[] args) {

		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10 - y; x++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
