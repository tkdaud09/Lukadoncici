package xyz.itwill06.oop;

//OOP ������ : ���ȭ(ĸ��ȭ)�� �ʹ� �����ؼ� �ٽɰ����ڵ�� Ⱦ�ܰ����ڵ带 �и��Ͽ� ���α׷� �ۼ��� �����
// => �ڵ��� �ߺ����� ���� ���α׷� ���꼺 �� ���������� ȿ������ ����
public class OopOne {
	/*
	private void beforeLog() {
		System.out.println("### �޼ҵ��� ���(�ٽɰ����ڵ�)�� ������� ���� ��ϵ� ���� ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		//Ⱦ�ܰ����ڵ� : ���α׷� ���࿡ �������� ����� �����ϱ� ���� ���
		// => �α� ó��, ���� ó��, Ʈ������ ó��, ���� ó�� ��
		//System.out.println("### �޼ҵ��� ���(�ٽɰ����ڵ�)�� ������� ���� ��ϵ� ���� ###");
		//beforeLog();
		logger.beforeLog();
		
		//�ٽɰ����ڵ� : ���α׷� ���࿡ �ٽ����� ����� �����ϴ� ��� - ����Ÿ ó�� ���
		System.out.println("*** OopOne Ŭ������ display1() �޼ҵ� ȣ�� ***");
	}
	
	public void display2() {
		//System.out.println("### �޼ҵ��� ���(�ٽɰ����ڵ�)�� ������� ���� ��ϵ� ���� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne Ŭ������ display2() �޼ҵ� ȣ�� ***");
	}
	
	public void display3() {
		//System.out.println("### �޼ҵ��� ���(�ٽɰ����ڵ�)�� ������� ���� ��ϵ� ���� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne Ŭ������ display3() �޼ҵ� ȣ�� ***");
	}
}