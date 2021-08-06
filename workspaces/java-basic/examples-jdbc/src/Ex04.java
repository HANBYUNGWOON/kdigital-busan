import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

class WinningNumbers {

	private int rnd;
	private Date lotteryDate;
	//private int[] numbers;
	private int no1;
	private int no2;
	private int no3;
	private int no4;
	private int no5;
	private int no6;
	private int bno;
	
	public int getRnd() {
		return rnd;
	}

	public void setRnd(int rnd) {
		this.rnd = rnd;
	}

	public Date getLotteryDate() {
		return lotteryDate;
	}

	public void setLotteryDate(Date lotteryDate) {
		this.lotteryDate = lotteryDate;
	}

	public int getNo1() {
		return no1;
	}

	public void setNo1(int no1) {
		this.no1 = no1;
	}

	public int getNo2() {
		return no2;
	}

	public void setNo2(int no2) {
		this.no2 = no2;
	}

	public int getNo3() {
		return no3;
	}

	public void setNo3(int no3) {
		this.no3 = no3;
	}

	public int getNo4() {
		return no4;
	}

	public void setNo4(int no4) {
		this.no4 = no4;
	}

	public int getNo5() {
		return no5;
	}

	public void setNo5(int no5) {
		this.no5 = no5;
	}

	public int getNo6() {
		return no6;
	}

	public void setNo6(int no6) {
		this.no6 = no6;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	// 필요하다면 생성자 메서드 구현 ( 초기화 메서드, new WinningNumbers() 하는 시점에 자동으로 호출 )
	public WinningNumbers() {}
	public WinningNumbers(int rnd, Date lotteryDate, int no1, int no2, int no3, int no4, int no5, int no6, int bno) {
		this.rnd = rnd;
		this.lotteryDate = lotteryDate;
		this.no1 = no1;
		this.no2 = no2;
		this.no3 = no3;
		this.no4 = no4;
		this.no5 = no5;
		this.no6 = no6;
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Date -> "2021-08-06"
		return String.format("[%5d][%10s][%2d][%2d][%2d][%2d][%2d][%2d][%2d]",
							 rnd, sdf.format(lotteryDate), no1, no2, no3, no4, no5, no6, bno);
	}	
	
}

public class Ex04 {

	public static void main(String[] args) {
		
		//read data from csv
		List<WinningNumbers> result = readLottoNumbersFromCsv("lotto-winning-numbers-by-round.csv");
		
		//create table 

		//insert data into database
		
	}

	private static List<WinningNumbers> readLottoNumbersFromCsv(String csvPath) {
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
													   Integer.parseInt(row[12]),
													   Integer.parseInt(row[13]),
													   Integer.parseInt(row[14]),
													   Integer.parseInt(row[15]),
													   Integer.parseInt(row[16]),
													   Integer.parseInt(row[17]),
													   Integer.parseInt(row[18]));
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
