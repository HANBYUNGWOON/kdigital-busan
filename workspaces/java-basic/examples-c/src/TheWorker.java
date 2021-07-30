
public class TheWorker {

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
