import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVReader;

class WinningNumbers {

   private int rnd;
   private Date lotteryDate;       // name, userName, 
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

public class ex04 {

   public static void main(String[] args) {

      //2-1. drop table
//      dropWinningNumbersTable();
//      System.out.println("테이블을 제거했습니다.");
      
      //2-2. create table
//      createWinningNumbersTable();
//      System.out.println("테이블을 만들었습니다.");
      
      // 1. read data from csv
      List<WinningNumbers> result = readLottoNumbersFromCsv("lotto-winning-numbers-by-round.csv");
      
      // test code
//      for ( WinningNumbers wn : result ) {
//         System.out.println(wn.toString());
//      }
      
      //3. insert data into database 
      //for (int i = 0; i < result.size(); i++) {  // 전체 데이터만 처리하도록 실행
      for (int i = 0; i <10; i++) {                // 효과적인 테스트를 위해서 10개의 데이터만 처리하도록 실행
         WinningNumbers wn = result.get(1); 
         insertWinningNumbers(wn); 
      }
      System.out.println("데이터를 데이터베이스에 저장했습니다.");
      
      //5. use database
      
   }

   private static void insertWinningNumbers(WinningNumbers wn) {

      Connection conn = null;         // 연결 객체의 참조를 저장할 변수
      PreparedStatement pstmt = null;   // 명령 객체의 참조를 저장할 변수
      
      // 0. 예외 처리 구조 만들기
      try {
         // 1. 드라이버 로딩 (등록)
         Class.forName("oracle.jdbc.OracleDriver");
         
         // 2. 연결 객체 만들기
         conn = DriverManager.getConnection(
               "jdbc:oracle:thin:@211.197.18.246:1551:xe",   // 사용할 데이터베이스 연결 정보 
               "madang", "madang");                  // 데이터베이스 사용자 계정
         
         // 3. SQL 작성 + 명령 객체 만들기
         String sql = "INSERT INTO WINNING_NUMBERS_ASM (RND, LOTTERY_DATE, NO1, NO2, NO3, NO4, NO5, NO6, BNO) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
         
         // VALUES (1, '2021-08-06', 12, 44, ... )
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, wn.getRnd());
         // java.util.Date --> java.sql.Date
         // java.util.Date.getTime() : 1970년 1월 1일 0시 0분 0초로부터 경과된 1/1000 초단위의 경과 값
         pstmt.setDate(2, new java.sql.Date(wn.getLotteryDate().getTime()));
         pstmt.setInt(3, wn.getNo1());
         pstmt.setInt(4, wn.getNo2());
         pstmt.setInt(5, wn.getNo3());
         pstmt.setInt(6, wn.getNo4());
         pstmt.setInt(7, wn.getNo5());
         pstmt.setInt(8, wn.getNo6());
         pstmt.setInt(9, wn.getBno());
         
         // 4. 명령 실행
         pstmt.executeUpdate(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
         
         // 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
         
      } catch (Exception ex) {
         ex.printStackTrace();// 콘솔에 오류 메시지를 출력
      } finally {
         // 6. 연결 닫기
         try { pstmt.close(); } catch (Exception ex) {}
         try { conn.close(); } catch (Exception ex) {}
      }
      
   }

   private static void dropWinningNumbersTable() {

      Connection conn = null;         // 연결 객체의 참조를 저장할 변수
      PreparedStatement pstmt = null;   // 명령 객체의 참조를 저장할 변수
      
      // 0. 예외 처리 구조 만들기
      try {
         // 1. 드라이버 로딩 (등록)
         Class.forName("oracle.jdbc.OracleDriver");
         
         // 2. 연결 객체 만들기
         conn = DriverManager.getConnection(
               "jdbc:oracle:thin:@211.197.18.246:1551:xe",   // 사용할 데이터베이스 연결 정보 
               "madang", "madang");                  // 데이터베이스 사용자 계정
         
         // 3. SQL 작성 + 명령 객체 만들기
         String sql = "DROP TABLE WINNING_NUMBERS_ASM ";
         pstmt = conn.prepareStatement(sql);
         
         // 4. 명령 실행
         pstmt.executeUpdate(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
         
         // 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
         
      } catch (Exception ex) {
         ex.printStackTrace();// 콘솔에 오류 메시지를 출력
      } finally {
         // 6. 연결 닫기
         try { pstmt.close(); } catch (Exception ex) {}
         try { conn.close(); } catch (Exception ex) {}
      }
      
   }

   private static void createWinningNumbersTable() {
      
      Connection conn = null;         // 연결 객체의 참조를 저장할 변수
      PreparedStatement pstmt = null;   // 명령 객체의 참조를 저장할 변수
      
      // 0. 예외 처리 구조 만들기
      try {
         // 1. 드라이버 로딩 (등록)
         Class.forName("oracle.jdbc.OracleDriver");
         
         // 2. 연결 객체 만들기
         conn = DriverManager.getConnection(
               "jdbc:oracle:thin:@211.197.18.246:1551:xe",   // 사용할 데이터베이스 연결 정보 
               "madang", "madang");                  // 데이터베이스 사용자 계정
         
         // 3. SQL 작성 + 명령 객체 만들기
         String sql = "CREATE TABLE WINNING_NUMBERS_ASM ( " +
                   "   RND NUMBER PRIMARY KEY, " +
                   "   LOTTERY_DATE DATE NOT NULL, " +
                   "   NO1 NUMBER NOT NULL CHECK(NO1 >= 1 AND NO1 <= 45), " +
                   "   NO2 NUMBER NOT NULL CHECK(NO2 >= 1 AND NO2 <= 45), " +
                   "   NO3 NUMBER NOT NULL CHECK(NO3 >= 1 AND NO3 <= 45), " +
                   "   NO4 NUMBER NOT NULL CHECK(NO4 >= 1 AND NO4 <= 45), " +
                   "   NO5 NUMBER NOT NULL CHECK(NO5 >= 1 AND NO5 <= 45), " +
                   "   NO6 NUMBER NOT NULL CHECK(NO6 >= 1 AND NO6 <= 45), " +
                   "   BNO NUMBER NOT NULL CHECK(BNO >= 1 AND BNO <= 45) " +
                   ")";
         pstmt = conn.prepareStatement(sql);
         
         // 4. 명령 실행
         pstmt.executeUpdate(); // executeQuery : select 명령용, executeUpdate : insert, update, delete, ...
         
         // 5. ( 명령 실행 결과가 있다면 - SELECT인 경우 ) 결과 처리
         
      } catch (Exception ex) {
         //ex.printStackTrace();// 콘솔에 오류 메시지를 출력
         System.out.println("테이블 생성 실패");
      } finally {
         // 6. 연결 닫기
         try { pstmt.close(); } catch (Exception ex) {}
         try { conn.close(); } catch (Exception ex) {}
      }
      
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
            String[] row = csvr.readNext();   // 파일에서 한 행의 데이터를 읽기 -> 문자열의 배열로 반환
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