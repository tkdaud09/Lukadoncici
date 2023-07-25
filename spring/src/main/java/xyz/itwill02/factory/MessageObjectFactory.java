package xyz.itwill02.factory;

//Factory ������ ������ �̿��Ͽ� �ۼ��� Ŭ���� - Factory Ŭ����(Provider Ŭ����)
// => ���α׷� ���߿� �ʿ��� ��ü�� �����Ͽ� ����� �����ϴ� Ŭ���� - �����̳�(Container)
public class MessageObjectFactory {
	//Factory Ŭ������ ���� ������ ��ü�� �����ϱ� ���� ���(Constant)
	public static final int HELLO_MSG=1;
	public static final int HI_MSG=2;
	
	//�Ű������� ���޵� ���� ���Ͽ� �ʿ��� ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => �������̽��� ��ӹ��� Ŭ������ ��ü�� �����Ͽ� ��ȯ
	public static MessageObject getMessageObject(int messageObject) {
		MessageObject object=null;
		switch(messageObject) {
		case HELLO_MSG:
			object=new HelloMessageObject();
			break;
		case HI_MSG:
			object=new HiMessageObject();
			break;	
		}
		return object; 
	}
}
