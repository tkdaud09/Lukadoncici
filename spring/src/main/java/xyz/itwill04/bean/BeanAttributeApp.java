package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("================= Spring Container �ʱ�ȭ �� =================");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("================= Spring Container �ʱ�ȭ �� =================");
		//ApplicationContext.getBean(String beanName) : ������ �����̳ʷκ��� �Ű������� ���޹��� 
		//beanName�� Spring Bean(��ü)�� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");

		//ApplicationContext.getBean(String beanName, Class<T> clazz) : ������ �����̳ʷκ���
		//�Ű������� ���޹��� beanName�� Spring Bean�� Class ��ü�� ��ü ����ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean ������Ʈ�� �̿��ϸ� �޼ҵ带 ��ü�� ������ �� �ڵ����� ȣ��ǵ��� ���� ����
		//bean.init();//�ʱ�ȭ �޼ҵ�
		
		bean.display();
		
		//bean ������Ʈ�� �̿��ϸ� �޼ҵ带 ��ü �Ҹ� �� �ڵ����� ȣ��ǵ��� ���� ����
		//bean.destroy();//������ �޼ҵ�
		System.out.println("==============================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("==============================================================");
		ScopeBean bean1=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean2=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean3=context.getBean("singletonBean", ScopeBean.class);
		
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
		ScopeBean bean4=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean5=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean6=context.getBean("singletonBean", ScopeBean.class);
		
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==============================================================");
	}
}