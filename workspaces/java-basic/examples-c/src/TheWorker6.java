
public class TheWorker6 extends Thread {
	
	@Override
	public void run() { //Thread가 시작되면 비동기 방식으로 호출되는 메서드
		doWork();
	}

	private static int result;
	
	//이 메서드는 다중 쓰레드 환경에서 동시에 호출될 수 없습니다.
	synchronized public static void doWork() {
		System.out.println("2. Beginning of doWork");
							
		result = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 10 == 0) { //10의 배수인 경우
				try { Thread.sleep(1000); } catch (Exception ex) {}
			}
			result = result + i;
		}			
		System.out.println("RESULT : " + result);
		
		System.out.println("3. End of doWork");		
	}

}
