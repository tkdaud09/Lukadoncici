package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-2_collection.xml");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		CollectionBean bean=context.getBean("collectionBean", CollectionBean.class);
		
		//CollectionBean ��ü�� �ʵ尪(Collection ��ü)�� ��ȯ�޾� ���
		// => Collection ��ü�� toString() �޼ҵ� ȣ�� - Collection ��ü�� ����� ��� ��Ұ� ���
		System.out.println("nameSet = "+bean.getNameSet());
		System.out.println("nameList = "+bean.getNameList());
		System.out.println("controllerSet = "+bean.getControllerSet());
		System.out.println("controllerList = "+bean.getControllerList());
		System.out.println("controllerMap = "+bean.getControllerMap());
		System.out.println("controllerProperties = "+bean.getControllerProperties());
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();		
	}
}