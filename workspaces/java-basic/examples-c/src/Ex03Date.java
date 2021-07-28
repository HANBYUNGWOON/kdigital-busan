import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex03Date {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println(d.toString());
		
		// 날짜를 문자열로 표현하는 형식을 관리하는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		
		String strd = sdf.format(d);
		System.out.println(strd);
		
		///////////////////////////
		
		Calendar c = Calendar.getInstance();
		System.out.printf("%d년 %d월 %d일\n", c.get(Calendar.YEAR), 
											 c.get(Calendar.MONTH) + 1, 
											 c.get(Calendar.DAY_OF_MONTH));

	}

}
