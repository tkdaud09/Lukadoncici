package xyz.itwill10.exception;

//������������ �������� ��û�� ��� �߻��� ���ܸ� ó���ϱ� ���� ���� Ŭ����
public class BadRequestException extends Exception {
	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		// TODO Auto-generated constructor stub
	}
	
	public BadRequestException(String message) {
		super(message);
	}
}