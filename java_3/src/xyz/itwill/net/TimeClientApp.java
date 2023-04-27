package xyz.itwill.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//NTP 서버에 접속하여 서버에서 보내온 날짜와 시간을 제공받아 출력하는 클라이언트 프로그램 작성
public class TimeClientApp {
	public static void main(String[] args) {
		try {
			//Socket 클래스 : TCP 프로그램에서 타겟 컴퓨터와 연결을 위한 정보를 저장하기
			//위한 클래스 - 다른 컴퓨터의 소켓과 연결되어 값을 송수신 할 수 있는 입출력 스트림 제공
			// => Socket 클래스의 Socket(String host, int port) 생성자를 이용하여 매개변수에 
			//접속 컴퓨터(서버)의 네트워크 식별자(호스트이름 또는 IP 주소)와 활성화된 포트번호를
			//전달하여 Socket 객체 생성 - 서버 접속
			// => UnknowHostException 및 IOException 발생 - 일반 예외이므로 반드시 예외처리
			Socket socket=new Socket("1.234.209.126", 2000);
		
		} catch (UnknownHostException e) {
			System.out.println("[에러]서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속 할 수 없습니다.");
		}
	}
}
