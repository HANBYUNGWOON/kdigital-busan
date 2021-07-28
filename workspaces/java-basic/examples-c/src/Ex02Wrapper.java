
public class Ex02Wrapper {

	public static void main(String[] args) {
		
		int x = 10;
		
		// Object obj = Integer.valueOf(x); // new Integer(x); 
		Object obj = x; 	// Auto Boxing
		
		System.out.println(obj);
		
		// int y = ((Integer)obj).intValue();
		int y = (int)obj;	// Auto Unboxing
		
		System.out.println(y);
		
		/////////////////////
		
		int z = Integer.parseInt("1000");
		int z2 = Integer.valueOf("1000");
		System.out.println(z);
		System.out.println(z2);

	}

}
