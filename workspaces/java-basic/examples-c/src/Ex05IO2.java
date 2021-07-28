import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05IO2 {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream("lotto-winning-numbers-by-round.csv"); // 파일에서 byte[] 형식으로 데이터 읽기 도구
			isr = new InputStreamReader(fis);	// byte[] -> char[] 변경하는 도구
			br = new BufferedReader(isr); // 행 단위로 데이터 읽는 도구
			while (true) {
				String line = br.readLine();// 파일에서 한 행의 데이터를 읽기
				if (line == null) { // EOF (end of file)
					break;
				}
				// System.out.println(line);
				String[] row = line.split(","); // "1,2,3" -> ["1", "2", "3"]
				System.out.printf("[%s][%s][%s][%s][%d]\n", row[0], row[1], row[2], row[3], row.length);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();	// 오류 메시지 표시
		} catch (IOException ex) {
			ex.printStackTrace();	// 오류 메시지 표시
		} finally {
			try { br.close(); } catch (Exception ex) {}
			try { isr.close(); } catch (Exception ex) {}
			try { fis.close(); } catch (Exception ex) {}
		}
		
		

	}

}
