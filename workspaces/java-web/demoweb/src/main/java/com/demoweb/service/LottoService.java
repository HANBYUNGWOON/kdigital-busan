package com.demoweb.service;

public class LottoService {

	public List<WinningNumbers> readLottoNumbersFromCsv(String csvPath) {
		FileReader fr = null;
		CSVReader csvr = null;
		ArrayList<WinningNumbers> result = new ArrayList<>(); // .csv 파일에서 읽은 당첨 번호 결과 목록을 저장할 컬렉션
		try {
			fr = new FileReader(csvPath);
			csvr = new CSVReader(fr);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			while (true) {
				String[] row = csvr.readNext();	// 파일에서 한 행의 데이터를 읽기 -> 문자열의 배열로 반환
				if (row == null) { // EOF (end of file)
					break;
				}
				// .csv의 한 행의 데이터를 읽어서 WinningNumbers 객체 만들기				
				WinningNumbers wn = new WinningNumbers(Integer.parseInt(row[0]),
													   sdf.parse(row[1]), // "yyyy.MM.dd" -> Date로 변환
													   Integer.parseInt(row[2]),
													   Integer.parseInt(row[3]),
													   Integer.parseInt(row[4]),
													   Integer.parseInt(row[5]),
													   Integer.parseInt(row[6]),
													   Integer.parseInt(row[7]),
													   Integer.parseInt(row[8]));
				result.add(wn); // 위에서 만든 WinningNumbers 객체를 목록에 추가
			}
		} catch (Exception ex) { // include FileNotFoundException, IOException, CsvValidationException, ParseException
			ex.printStackTrace();
		} finally {
			try { csvr.close(); } catch (Exception ex) {}
			try { fr.close(); } catch (Exception ex) {}
		}
		return result;
	}

}