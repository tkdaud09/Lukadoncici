package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

//컴퍼넌트에서는 다양한 이벤트가 발생되며 컴퍼넌트에서 이벤트가 발생될 경우 원하는 기능을
//구현하여 실행되도록 프로그램 작성 - 이벤트 처리 프로그램

//이벤트 처리 프로그램 작성 방법
//1.컴퍼넌트와 컨테이너 관련 클래스를 사용하여 디자인 클래스 작성 - UI 구현
// => Frame 클래스를 상속받아 디자인 클래스 작성
// => 컴퍼넌트 또는 컨테이너에서 다양한 이벤트 발생

//[EXIT] 버튼을 누른 경우 프로그램 종료하는 기능의 프로그램 작성
public class EventHandleApp extends Frame {
	private static final long serialVersionUID = 1L;
		
	public EventHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandleApp("이벤트처리");
	}
}
