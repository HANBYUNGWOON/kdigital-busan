import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex05Gui2 extends JFrame {
	
	public Ex05Gui2() {
		initUI();
	}
	private void initUI() {
		setTitle("Hello, Java GUI Programming");
		setSize(600, 500);
		setLocation(300, 200);
		
		Container container = getContentPane(); // 윈도우에서 사용자 표시 영역 객체 가져오기
		container.setBackground(Color.orange);
		
		// 버튼 만들고 윈도우에 부착
		JButton button = new JButton("클릭해 주세요");
		button.setSize(300, 100);
		button.setLocation(150, 200);
		
		ButtonClickHandler handler = new ButtonClickHandler();// 버튼이 클릭되면 호출될 메서드를 가진 인스턴스 만들기
		button.addActionListener(handler);// Button과 Button 클릭 처리기 연결
		
		add(button);		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우가 닫히면 프로그램을 종료하는 설정
		setLayout(null); // 윈도우 내에 포함된 컴포넌트의 위치를 임의로 설정
	}
	
	// 포함클래스 : 다른 클래스 내부에 만드는 클래스
	class ButtonClickHandler implements ActionListener { // 버튼과 다른 클래스를 연결할 때 적용할 규약

		@Override
		public void actionPerformed(ActionEvent e) { // 버튼을 클릭하면 호출될 약속된 메서드
			
			//JOptionPane.showMessageDialog(null, "Thank you !!!!");// 메시지 창을 표시하는 메서드 호출
			Container container = getContentPane(); // 윈도우에서 사용자 표시 영역 객체 가져오기
			int r = (int)(Math.random() * 256); // Red 강도 : 0 ~ 255
			int g = (int)(Math.random() * 256);	// Green 강도 : 0 ~ 255
			int b = (int)(Math.random() * 256);	// Blue 강도 : 0 ~ 255
			Color c = new Color(r, g, b); // Color : 색상 관리 클래스
			container.setBackground(c);
		}
		
		
		
	}

	public static void main(String[] args) {
		
		Ex05Gui2 frame = new Ex05Gui2();
		
		frame.setVisible(true); // 윈도우를 화면에 표시하는 명령

	}

}
