import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

class NoAndCount implements Comparable<NoAndCount> {
	private int no;
	private int count;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public NoAndCount() {}
	public NoAndCount(int no, int count) {
		this.no = no;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return String.format("[%2d : %4d]", no, count);
	}
	
	@Override
	public int compareTo(NoAndCount o) {
		return this.count - o.count; // +는 this가 크다, 0는 this와 o가 같다, -는 this가 작다
	}
}

public class Ex05IO5 {

	public static void main(String[] args) {
		
		FileReader fr = null;
		CSVReader csvr = null;
		try {
			fr = new FileReader("lotto-winning-numbers-by-round.csv"); // 파일에서 byte[] 형식으로 데이터 읽기 도구
			csvr = new CSVReader(fr);
			NoAndCount[] list = new NoAndCount[45]; // 각 번호별 당첨 빈도를 저장하는 배열
			for (int i = 0; i < list.length; i++) {
				// list[i].setNo(i + 1);
				// list[i].setCount(0);
				list[i] = new NoAndCount(i + 1, 0);
			}
			while (true) {
				String[] row = csvr.readNext();	// 파일에서 한 행의 데이터를 읽기
				if (row == null) { // EOF (end of file)
					break;
				}
				
				for (int i = 12; i < row.length; i++) { // 12번 위치가 당첨 번호가 나오는 첫 번째 위치
					int no = Integer.parseInt(row[i]);	// "34" -> 34
					for (int j = 0; j < list.length; j++) {
						if (list[j].getNo() == no) {
							list[j].setCount( list[j].getCount() + 1 );
							break;
						}
					}
				}
			}
			
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i]);
				if ( (i + 1) % 10 == 0 ) { // 10번째 데이터 마다 한 번씩 줄바꿈
					System.out.println();
				}
			}
			System.out.println();
			
			Arrays.sort(list);
			
			System.out.printf("가장 많이 당첨된 번호와 횟수 %s\n", list[list.length - 1]);
			System.out.printf("두번째로 많이 당첨된 번호와 횟수 %s\n", list[list.length - 2]);
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();	// 오류 메시지 표시
		} catch (IOException ex) {
			ex.printStackTrace();	// 오류 메시지 표시
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} finally {
			try { csvr.close(); } catch (Exception ex) {}
			try { fr.close(); } catch (Exception ex) {}
		}
		
		

	}

}
