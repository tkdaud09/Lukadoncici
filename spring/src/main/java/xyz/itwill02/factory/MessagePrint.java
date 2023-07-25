package xyz.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//��ü�� ���� �����Ͽ� �޼ҵ� ȣ�� - ��ü���� ���յ��� ���� ���������� ȿ�Ｚ ����
		//MessageObject object=new HelloMessageObject();
		
		//���α׷� ���࿡ �ʿ��� ��ü�� Factory Ŭ�����κ��� �����޾� �޼ҵ� ȣ��
		// => IoC(Inversion of Control) : ������ ���� - ��ü���� ���յ��� ���� ���������� ȿ���� ����
		//MessageObject object=MessageObjectFactory.getMessageObject(1);
		MessageObject object=MessageObjectFactory.getMessageObject(2);
		
		//�������̽��� ������ ���������� �߻�޼ҵ带 ȣ���ϴ� ��� ���������� ����� �ڽ� ��ü��
		//�������̵� �޼ҵ� ȣ�� - ������ ��ü ����ȯ : �������̵忡 ���� ������
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}
