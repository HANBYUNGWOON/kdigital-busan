
public class Ex04ControlStatement11 {

	public static void main(String[] args) {
		
		// 박스 그리기 ( width:20 X height:10 )
		// ##### (엔터)
		// #####
		// #####
		// #####

		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 20; x++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println("\n\n");
		
		// #####
		// #   #
		// #   #
		// #####
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 20; x++) {
				//조건에따라
				if (y == 0 || y == 9 || x == 0 || x == 19) {
					System.out.print("#");
				} else {				
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
