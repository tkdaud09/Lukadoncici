package xyz.itwill10.exception;

import lombok.Getter;
import xyz.itwill10.dto.Userinfo;

//ȸ�������� ����� �� ����ڷκ��� �Է¹��� ȸ�������� ���̵� ���� ȸ�������� ���̵��
//�ߺ��� ��� �߻��� ���ܸ� ó���ϱ� ���� ���� Ŭ����
public class ExistsUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//����ó���� �ʿ��� ���� �����ϱ� ���� �ʵ�
	// => ����ں��� �Է¹��� ȸ�������� �����ϱ� ���� �ʵ�
	@Getter
	private Userinfo userinfo;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	//�Ű������� ���� �޼����� ����ó���� �ʿ��� ���� ���޹޾� �ʵ忡 ���� 
	public ExistsUserinfoException(String message, Userinfo userinfo) {
		super(message);
		this.userinfo=userinfo;
	}
}