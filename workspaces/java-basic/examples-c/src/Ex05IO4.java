import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Ex05IO4 {

	public static void main(String[] args) {
		
		FileReader fr = null;
		CSVReader csvr = null;
		try {
			fr = new FileReader("lotto-winning-numbers-by-round.csv"); // 파일에서 byte[] 형식으로 데이터 읽기 도구
			csvr = new CSVReader(fr);
			int[] countByNo = new int[45]; // 각 번호별 당첨 빈도를 저장하는 배열
			while (true) {
				String[] row = csvr.readNext();	// 파일에서 한 행의 데이터를 읽기
				if (row == null) { // EOF (end of file)
					break;
				}
				
				for (int i = 12; i < row.length; i++) { // 12번 위치가 당첨 번호가 나오는 첫 번째 위치
					int no = Integer.parseInt(row[i]);	// "34" -> 34
					countByNo[no - 1] = countByNo[no - 1] + 1; // 현재 번호의 배열 값을 1 증가 (Count 증가)
					//countByNo[no-1]++;
				}
			}
			
			for (int i = 0; i < countByNo.length; i++) {
				System.out.printf("[%2d : %3d]", (i + 1), countByNo[i]);
				if ( (i + 1) % 10 == 0 ) { // 10번째 데이터 마다 한 번씩 줄바꿈
					System.out.println();
				}
			}
			System.out.println();
			
			// 가장 많이 당첨된 번호 찾기
			int no = 0, count = 0;
			for (int i = 0; i < countByNo.length; i++) {
				if (countByNo[i] > count) {
					count = countByNo[i];
					no = i + 1;
				}
			}
			System.out.printf("가장 많이 당첨된 번호와 횟수 [%2d : %3d]\n", no, count);
			
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
