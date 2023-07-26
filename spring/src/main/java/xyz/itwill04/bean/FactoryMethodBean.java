package xyz.itwill04.bean;

//�̱��� ������ ������ �����Ͽ� �ۼ��� Ŭ���� - �̱��� Ŭ���� (Singleton Class)
// => ���α׷��� �ʿ��� ��ü�� �ϳ��� �����ϱ� ���� ������ Ŭ������ �ۼ��� �� ����ϴ� ������
public class FactoryMethodBean {
	private static FactoryMethodBean _bean;
	
	public FactoryMethodBean() {
		System.out.println("### FactoryMethodBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	static {
		_bean=new FactoryMethodBean();
	}
	
	public static FactoryMethodBean getFactoryMethodBean() {
		return _bean;
	}
}
