package xyz.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void init() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ init() �޼ҵ� ȣ�� ***");
	}
	
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ destroy() �޼ҵ� ȣ�� ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
}