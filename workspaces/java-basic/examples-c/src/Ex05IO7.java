import java.io.FileReader;

import com.opencsv.CSVReader;

public class Ex05IO7 {

	public static void main(String[] args) {
		
		//1. seoul-covid19.csv 파일을 읽어서 각 행별로 데이터 출력
		FileReader fr = null;
		CSVReader csvr = null;
		
		try {
			fr = new FileReader("seoul-covid19.csv");
			csvr = new CSVReader(fr);
			String guNames = "";
			while (true) {
				String[] row = csvr.readNext();
				if (row == null) {
					break;
				}
				//System.out.printf("[%s][%s][%s][%s][%s]\n", row[0], row[1], row[5], row[7], row[13]);
				
				String gu = row[5].trim();	// trim() : 문자열 양 끝에서 공백 제거
				if (!gu.equals("0") && !guNames.contains(gu)) { // guNames 문자열에 gu가 포함되어 있는지 확인 (포함되지 않았을 때 true)
					if (guNames.length() == 0) {
						guNames += gu;
					} else {
						guNames += ";" + gu;
					}
				}				
			}
			// System.out.println(guNames);
			String[] names = guNames.split(";");
			for (String name : names) {
				System.out.println(name);
			}
			
			// 1. 특정 자치구를 선택해서 총 확진자 수를 계산 ( 예를 들어 "마포구" )
			// 2. 전체 자치구별 총 확진자 수를 계산
			
			
		} catch (Exception ex) {
			
		} finally {
			
		}
		

	}

}
