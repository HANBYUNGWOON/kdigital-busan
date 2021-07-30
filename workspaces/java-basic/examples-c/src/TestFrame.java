import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFrame extends JFrame {

	public TestFrame() {
		initUI();
	}

	private void initUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		setTitle("쓰레드 테스트");
		setSize(308, 420);
		
		JButton btn = new JButton("동기 방식 호출");
		btn.setSize(270, 50);
		btn.setLocation(10, 10);
		btn.addActionListener( (e) -> {
			
			System.out.println("1. Before calling doWork");
			TheWorker worker = new TheWorker();
			worker.doWork(); // 동기 방식 호출
			System.out.println("4. After calling doWork");
			
		} );
		add(btn);
		
		btn = new JButton("비동기 방식 호출 (Thread 상속)");
		btn.setSize(270, 50);
		btn.setLocation(10, 70);
		btn.addActionListener( (e) -> {
			
			System.out.println("1. Before calling doWork");
			TheWorker2 worker = new TheWorker2();
			worker.start(); //쓰레드를 시작하는 명령 ( 비동기 호출 ) // --> 비동기 방식으로 run() 호출
			System.out.println("4. After calling doWork");
			
		});
		add(btn);
		
		btn = new JButton("비동기 방식 호출 (Runnable 구현)");
		btn.setSize(270, 50);
		btn.setLocation(10, 130);
		btn.addActionListener( (e) -> {
			
			System.out.println("1. Before calling doWork");
			TheWorker3 worker = new TheWorker3();
			Thread thread = new Thread(worker);
			thread.start(); //thread.start -> thread.run -> worker.run
			System.out.println("4. After calling doWork");
			
		});
		add(btn);
		
		btn = new JButton("비동기 방식 호출의 문제");
		btn.setSize(270, 50);
		btn.setLocation(10, 190);
		btn.addActionListener( (e) -> {
			
			System.out.println("1. Before calling doWork");
			
			TheWorker4 worker = new TheWorker4();
			worker.start(); //쓰레드를 시작하는 명령
			
			try { Thread.sleep(1000); } catch (Exception ex) {}
			
			TheWorker4 worker2 = new TheWorker4();
			worker2.start(); //쓰레드를 시작하는 명령
			
			System.out.println("4. After calling doWork");
			
		});
		add(btn);
		
		btn = new JButton("쓰레드 동기화 1");
		btn.setSize(270, 50);
		btn.setLocation(10, 250);
		btn.addActionListener( (e) -> {
			
			System.out.println("1. Before calling doWork");
			TheWorker5 worker = new TheWorker5();
			worker.start(); //쓰레드를 시작하는 명령
			
			try { Thread.sleep(1000); } catch (Exception ex) {}
			
			TheWorker5 worker2 = new TheWorker5();
			worker2.start(); //쓰레드를 시작하는 명령
			System.out.println("4. After calling doWork");
			
		});
		add(btn);
		
		btn = new JButton("쓰레드 동기화 2");
		btn.setSize(270, 50);
		btn.setLocation(10, 310);
		btn.addActionListener( (e) -> {
			System.out.println("1. Before calling doWork");
			TheWorker6 worker = new TheWorker6();
			worker.start(); //쓰레드를 시작하는 명령
			
			try { Thread.sleep(1000); } catch (Exception ex) {}
			
			TheWorker6 worker2 = new TheWorker6();
			worker2.start(); //쓰레드를 시작하는 명령
			System.out.println("4. After calling doWork");
		});
		add(btn);
		
	}
	
}







