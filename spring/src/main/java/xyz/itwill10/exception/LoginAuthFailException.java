package xyz.itwill10.exception;

import lombok.Getter;

//�α��� ó���Ҷ� ����ڷκ��� �Է¹��� ���̵�� ��й�ȣ�� ���� ������ ������ ��� �߻��� 
//���ܸ� ó���ϱ� ���� ���� Ŭ����
public class LoginAuthFailException extends Exception {
	private static final long serialVersionUID = 1L;

	//����ó���� �ʿ��� ���� �����ϱ� ���� �ʵ�
	// => ����ں��� �Է¹��� ���̵� �����ϱ� ���� �ʵ�
	@Getter
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginAuthFailException(String message, String userid) {
		super(message);
		this.userid=userid;
	}
}