import java.io.Serializable;

//스트림에 저장하거나 스트림에서 읽는 객체는 반드시 Serializable 인터페이스를 구현해야 합니다.
public class Item implements Serializable {
		
	private int no;
	private String name;
		
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("[%d][%s]", no, name);
	}

}
