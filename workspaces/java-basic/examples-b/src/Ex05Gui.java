import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex05Gui {

	public static void main(String[] args) {
		
		JFrame frame;
		frame = new JFrame();	// 윈도우 인스턴스 만들기
		//JFrame frame2 = new JFrame();
		
		frame.setTitle("Hello, Java GUI Programming");
		frame.setSize(600, 500);
		frame.setLocation(300, 200);
		
		Container container = frame.getContentPane(); // 윈도우에서 사용자 표시 영역 객체 가져오기
		container.setBackground(Color.orange);
		
		// 버튼 만들고 윈도우에 부착
		JButton button = new JButton("클릭해 주세요");
		button.setSize(300, 100);
		button.setLocation(150, 200);
		frame.add(button);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우가 닫히면 프로그램을 종료하는 설정
		frame.setLayout(null); // 윈도우 내에 포함된 컴포넌트의 위치를 임의로 설정
		
		frame.setVisible(true); // 윈도우를 화면에 표시하는 명령

	}

}
