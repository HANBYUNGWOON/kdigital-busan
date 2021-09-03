package com.demoweb.service;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.demoweb.dao.LottoDao;
import com.demoweb.dao.LottoDaoImpl;
import com.demoweb.vo.WinningNumbers;
import com.opencsv.CSVReader;

public class LottoServiceImpl implements LottoService {
	
	@Override
	public void initData(String csvPath) {
		// csv 파일을 읽어서 WinningNumbers 리스트 만들기
		List<WinningNumbers> list = readLottoNumbersFromCsv(csvPath);
		
		LottoDao lottoDao = new LottoDaoImpl();
		// 테이블 제거
		lottoDao.dropWinningNumbersTable();
		// 테이블 생성
		lottoDao.createWinningNumbersTable();
//		// 데이터 저장 1. 한 번에 한 개씩 여러 번 반복 저장
//		for (WinningNumbers wn : list) {
//			lottoDao.insertWinningNumbers(wn);
//		}
		//데이터 저장 2. 한 번에 여러 개의 데이터 저장
		lottoDao.insertWinningNumbers2(list);
		
	}

	@Override
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

	@Override
	public int[] loadStatsByNumber(boolean includeBno, int rndFrom, int rndTo) {
		LottoDao lottoDao = new LottoDaoImpl();
		int[] countByNumber = lottoDao.selectStatsByNumber(includeBno, rndFrom, rndTo);
		return countByNumber;
	}
}