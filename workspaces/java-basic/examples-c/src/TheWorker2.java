
//쓰레드를 만드는 방법 1 : Thread 클래스를 상속하고 run() 메서드를 재정의
public class TheWorker2 extends Thread {
	
	@Override
	public void run() { //Thread가 시작되면 비동기 방식으로 호출되는 메서드
		doWork();
	}

	public void doWork() {
		System.out.println("2. Beginning of doWork");
		try {
			Thread.sleep(10 * 1000);//10초간 현재 쓰레드의 실행 중지
		} catch (Exception ex) {
			//do nothing
		}
		System.out.println("3. End of doWork");
		
	}

}
