
public class Ex04ControlStatement2 {
	
	public static void main(String[] args) {
		
		double number = Math.random(); // 0 ~ 1 사이의 난수 발생 (1은 포함되지 않습니다.)
		// System.out.println(number);
		
		number = number * 5; // 0 ~ 1 -> 0 ~ 5 사이의 난수 (실수)
		// System.out.println(number);
		
		int inumber = (int)number + 1; // 1 ~ 6 사이의 난수 (정수)
		System.out.println(inumber);
		
		switch (inumber) {
		case 1: 
			System.out.println("3보다 작습니다."); 
			break; // 여기서 switch case 문을 종료합니다.
		case 2: 
			System.out.println("3보다 작습니다.");
			break;
		case 3: 
			System.out.println("3입니다.");
			break;
		case 4: 
			System.out.println("3보다 큽니다.");
			break;
		case 5: 
			System.out.println("3보다 큽니다.");
			break;
		}
		
		System.out.println("================================");
		
		switch (inumber) {
		case 1: 
		case 2: 
			System.out.println("3보다 작습니다.");
			break;
		case 3: 
			System.out.println("3입니다.");
			break;
		case 4: 
		case 5: 
			System.out.println("3보다 큽니다.");
			break;
		}
		
		
	}

}
