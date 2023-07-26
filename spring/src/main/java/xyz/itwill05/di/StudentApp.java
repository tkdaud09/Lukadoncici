package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		Student student1=context.getBean("student1", Student.class);
		//���������� ����� ��� ���������� ���嵵�� ��ü�� toString() �޼ҵ� �ڵ� ȣ�� - ��ü��
		System.out.println(student1);
		System.out.println("==========================================================");
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2);
		System.out.println("==========================================================");
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3);
		System.out.println("==========================================================");
		Student student4=context.getBean("student4", Student.class);
		System.out.println(student4);
		System.out.println("==========================================================");
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("==========================================================");
		Student student6=context.getBean("student6", Student.class);
		System.out.println(student6);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
