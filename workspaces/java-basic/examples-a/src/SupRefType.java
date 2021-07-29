
class Item {
	int no;
	String name;
}

public class SupRefType {

	public static void main(String[] args) {
		
		// primitive type : 이름 ---> [ 값 ]
		int x;
		x = 10;
		
		// reference type : 이름 ---> [ 참조(주소) ] ---> [ 값 ]
		// 참조 변수 = 인스턴스
		Item item = null;
		//item.no = 0;
		item = new Item();
		item.no = 1;
		item.name = "Nail";
		// item ---> [ 주소 ] ---> [ no : 1, name : Nail ]
		
		Item item2 = new Item();
		item2.no = 1;
		item2.name = "Nail";
		// item2 ---> [ 주소 ] ---> [ no : 1, name : Nail ]
		
		System.out.println(item == item2);
		
		///////////////////////////
		
		String str1 = new String("Hello");
		// str1 ---> [ 주소 ] ---> [ Hello ]
		String str2 = new String("Hello");
		// str2 ---> [ 주소 ] ---> [ Hello ]
		System.out.println(str1 == str2); // false
		System.out.println(str1.equals(str2)); // true
	}

}
