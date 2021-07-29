import java.io.FileReader;

import com.opencsv.CSVReader;

public class Ex05IO6 {

	public static void main(String[] args) {
		
		//1. seoul-covid19.csv 파일을 읽어서 각 행별로 데이터 출력
		FileReader fr = null;
		CSVReader csvr = null;
		
		try {
			fr = new FileReader("seoul-covid19.csv");
			csvr = new CSVReader(fr);
			while (true) {
				String[] row = csvr.readNext();
				if (row == null) {
					break;
				}
				System.out.printf("[%s][%s][%s][%s][%s]\n", row[0], row[1], row[5], row[7], row[13]);
			}
		} catch (Exception ex) {
			
		} finally {
			
		}
		

	}

}
