package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);//��ü �ʵ忡 ��ü�� �����Ͽ� ���� - ���԰��� �ϼ�
		print.messagePrint();
		*/
		
		//ApplicationContext ��ü : ������ �����̳�(Spring Container) ����� �����ϱ� ���� ��ü
		// => Spring Bean Configuration File(XML)�� �����޾� ��ü(Spring Bean)�� �����Ͽ� ����
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring �����̳ʿ��� �ʿ��� Spring Bean(��ü)�� �����޾� ����
		// => �Ű������� Spring Bean�� �����ϱ� ���� �ĺ���(beanName �Ǵ� beanId)�� ����
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		
		print.messagePrint();

		//ApplicationContext ��ü ���� - Spring �����̳� �Ҹ� 
		// => Spring �����̳ʰ� �����ϴ� ��� Spring Bean(��ü) �Ҹ� 
		((ClassPathXmlApplicationContext)context).close();
	}
}








