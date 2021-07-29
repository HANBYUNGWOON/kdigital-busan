import java.io.FileReader;

import com.opencsv.CSVReader;

public class Ex05IO8 {

	public static void main(String[] args) {
		
		//1. seoul-covid19.csv 파일을 읽어서 각 행별로 데이터 출력
		FileReader fr = null;
		CSVReader csvr = null;
		
		try {
			fr = new FileReader("seoul-covid19.csv");
			csvr = new CSVReader(fr);
			String guNames = "";
			int count = 0;
			while (true) {
				String[] row = csvr.readNext();
				if (row == null) {
					break;
				}
				//System.out.printf("[%s][%s][%s][%s][%s]\n", row[0], row[1], row[5], row[7], row[13]);
				
				String guName = row[5].trim();
				if (guName.equals("강서구")) {
					count++;
				}
							
			}
			// 1. 특정 자치구를 선택해서 총 확진자 수를 계산 ( 예를 들어 "마포구" )
			System.out.printf("강서구의 총 확진자 수 : %5d\n", count);
			
			// 2. 전체 자치구별 총 확진자 수를 계산
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
		}
		

	}

}
