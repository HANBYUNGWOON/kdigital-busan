import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

public class Ex05IO8 {

	public static void main(String[] args) {
		
		//1. seoul-covid19.csv 파일을 읽어서 각 행별로 데이터 출력
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileReader fr = null;
		CSVReader csvr = null;
		
		try {
			// 파일에서 구 이름을 읽고 배열에 저장
			fis = new FileInputStream("gu-name.txt");
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String[] guNames = new String[27];
			int i = 0;
			while (true) {
				String gu = br.readLine();
				if (gu == null) {
					break;
				}
				guNames[i] = gu.trim();
				i++;
			}
			// 테스트 코드
//			for (String g : guNames) {
//				System.out.println(g);
//			}
			
			
			fr = new FileReader("seoul-covid19.csv");
			csvr = new CSVReader(fr);
			
			int count = 0; // 특정 자치구의 확진자 수를 저장할 변수
			int[] countByGu = new int[27]; // 전체 자치구별 확진자 수를 저장할 변수
			while (true) {
				String[] row = csvr.readNext();
				if (row == null) {
					break;
				}
				
				String guName = row[5].trim();
				// 특정 구에 대한 확진자 수 증가
				if (guName.equals("강서구")) {
					count++;
				}
				
				// 각 구 이름을 순회하면서 일치하는 구에 대해 카운트 증가
				for (int k = 0; k < guNames.length; k++) {
					if (guNames[k].equals(guName)) {
						countByGu[k] = countByGu[k] + 1;
						break;
					}
				}
							
			}
			// 1. 특정 자치구를 선택해서 총 확진자 수를 계산 ( 예를 들어 "마포구" )
			System.out.printf("강서구의 총 확진자 수 : %5d\n", count);
			
			// 2. 전체 자치구별 총 확진자 수를 계산
			for (int k = 0; k < guNames.length; k++) {
				System.out.printf("[%7s : %5d]", guNames[k], countByGu[k]);
				if ( (k + 1) % 10 == 0) {
					System.out.println();
				}
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
		}
		

	}

}
