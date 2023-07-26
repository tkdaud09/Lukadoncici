package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
 
//Spring �����ӿ�ũ������ BeanFactory ��ü �Ǵ� ApplicationContext ��ü�� ������ �����̳�(Spring Container) ��� ����
// => ������ �����̳ʴ� ȯ�漳������(Spring Bean Configuration File - XML)�� Ŭ������ �����޾� Spring Bean(��ü) ����
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory ��ü�� �����Ͽ� ������ �����̳ʷ� ����ϴ� ���");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//BeanFactory �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü ���� - BeanFactory ��ü 
		// => BeanFactory ��ü�� ������ �� Spring Bean Configuration File�� �����޾� ������ �����̳� ���� - ������ �����̳� �ʱ�ȭ �۾� 
		// => �Ű��������� Spring Bean Configuration File�� ��θ� �����޾� Resource ��ü�� �����Ͽ� ����
		// => BeanFactory ��ü�� Spring Bean Configuration File�� ��ϵ� Ŭ������ �̸� ��ü�� �������� �ʰ� Spring Bean ��û�� �����Ͽ� ����
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//BeanFactory.getBean(String beanName) : �Ű������� Spring Bean�� �����ϱ� ���� 
		//�ĺ���(beanName)�� ���޹޾� ������ �����̳ʷκ��� Spring Bean(��ü)�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		// => �Ű������� ���޹��� �ĺ���(beanName)�� Spring Bean�� ���� ��� NoSuchBeanDefinitionException �߻�
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("==========================================================");
		System.out.println("2.ApplicationContext ��ü�� �����Ͽ� ������ �����̳ʷ� ����ϴ� ���");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//ApplicationContext �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü ���� - ApplicationContext ��ü
		// => ApplicationContext ��ü�� ������ �� Spring Bean Configuration File�� �����޾� 
		//������ �����̳� ���� - ������ �����̳� �ʱ�ȭ �۾� 
		// => Ŭ������ ���� ������ ����(ClassPath)�� ����� Spring Bean Configuration File�� �����޾� ���
		// => ApplicationContext ��ü�� Spring Bean Configuration File�� ��ϵ� Ŭ������ �̸� 
		//��ü�� �����Ͽ� Spring Bean ��û�� �̸� ������ ��ü�� ����		
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//DL(Dependency Lookup) : ������ �����̳ʰ� �����ϴ� ��ü(Spring Bean)�� �˻��Ͽ� �����ϴ� ��� 
		//ApplicationContext.getBean(String beanName) : �Ű������� Spring Bean�� �����ϱ� ���� 
		//�ĺ���(beanName)�� ���޹޾� ������ �����̳ʷκ��� Spring Bean(��ü)�� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		// => �Ű������� ���޹��� �ĺ���(beanName)�� Spring Bean�� ���� ��� NoSuchBeanDefinitionException �߻�
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext ��ü�� �����ϴ� �޼ҵ�
		// => ������ �����̳ʰ� �Ҹ�Ǳ� ���� ������ �����̳ʿ� ���� �����Ǵ� ��� ��ü(Spring Bean)�� �ڵ� �Ҹ�
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	} 
}