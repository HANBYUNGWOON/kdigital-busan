import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opencsv.CSVReader;

class ConfirmedCase {
	
	private int caseNo;
	private String confirmedDate;
	private String region;
	private String status;
	private boolean contacted;

	public int getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(int caseNo) {
		this.caseNo = caseNo;
	}
	public String getConfirmedDate() {
		return confirmedDate;
	}
	public void setConfirmedDate(String confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isContacted() {
		return contacted;
	}
	public void setContacted(boolean contacted) {
		this.contacted = contacted;
	}
	
	public ConfirmedCase() {}
	public ConfirmedCase(int caseNo, String confirmedDate, String region, String status, boolean contacted) {
		this.caseNo = caseNo;
		this.confirmedDate = confirmedDate;
		this.region = region;
		this.status = status;
		this.contacted = contacted;
	}
	@Override
	public String toString() {
		return String.format("[%6d][%s][%5s][%b][%s]", caseNo,
													   confirmedDate,
													   region,
													   contacted,
													   status);
	}
	
}

public class Ex05IO9 {

	public static void main(String[] args) {
		
		// seoul-covid19.csv 파일을 읽어서 각 행별로 객체를 만들어서 목록에 저장
		FileReader fr = null;
		CSVReader csvr = null;
		
		ArrayList<ConfirmedCase> cases = new ArrayList<>(); // 파일에서 읽은 각 행의 데이터를 객체로 만들어서 목록으로 관리하기 위한 컬렉션 객체
		
		try {
			fr = new FileReader("seoul-covid19.csv");
			csvr = new CSVReader(fr);
			while (true) {
				String[] row = csvr.readNext();
				if (row == null) {
					break;
				}
				//System.out.printf("[%s][%s][%s][%s][%s]\n", row[0], row[1], row[5], row[7], row[13]);
				// 한 행의 데이터를 읽어서 ConfirmedCase 인스턴스를 생성
				ConfirmedCase cc = new ConfirmedCase(Integer.parseInt(row[0]),
													 row[1],
													 row[5],
													 row[7],
													 row[13].toLowerCase().equals("y")); // String.toLowerCase() -> 소문자로 변경
				
				cases.add(cc); // 한 행의 데이터로 만든 ConfirmedCase 인스턴스를 목록에 추가
			}			
			
		} catch (Exception ex) {			
		} finally {
		}
		
		// 파일에서 읽어서 객체에 저장한 데이터 사용
		for (ConfirmedCase c : cases) {
			System.out.println(c);
		}
		

	}

}












