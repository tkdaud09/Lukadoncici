package xyz.itwill03.spring;

public class MessagePrint {
	//MessageObject �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü�� �����ϱ� ���� �ʵ�
	// => �ʵ忡 ��ü�� �����ϱ� ���� ������ �Ǵ� Setter �޼ҵ带 �ݵ� �ۼ� - ���԰���
	// => �ʵ忡 ����� ��ü�� ����Ͽ� �޼ҵ� ȣ�� ����
	private MessageObject object;
	
	public MessageObject getObject() {
		return object;
	}
	
	public void setObject(MessageObject object) {
		this.object = object;
	}
	
	public void messagePrint() {
		//�ʵ忡 ��ü�� ������� ���� ��� NullPointException �߻� NPE
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
	
}
