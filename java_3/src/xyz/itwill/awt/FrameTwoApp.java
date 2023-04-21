package xyz.itwill.awt;

import java.awt.Frame;

//GUI 프로그램을 UI 구성 및 이벤트 처리를 위해 Frame 클래스를 상속받아 작성하는 것을 권장
public class FrameTwoApp extends Frame{
	private static final long serialVersionUID = 1L;

	//생성자에서 프레임을 구성하는 디자인 설정 - UI 구현
	public FrameTwoApp(String title) {
		super("title");
	}
	
	public static void main(String[] args) {
		//Frame 클래스를 상속받은 자식클래스로 객체 생성
		// => Frame 객체 생성 - 프레임 생성
		new FrameTwoApp("프레임 연습");
	}
}
