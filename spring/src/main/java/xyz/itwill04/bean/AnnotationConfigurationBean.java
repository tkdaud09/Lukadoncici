package xyz.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : ������ �����̳ʿ� ���� ������ ��ü(Spring Bean)�� �����Ͽ� ��ȯ�ϴ� �޼ҵ尡
//����� Ŭ������ �����ϱ� ���� ������̼�
// => Ŭ������ Spring Bean Configuration File�� ������ ����� �����ϴ� ������̼�
@Configuration
public class AnnotationConfigurationBean {
	//@Bean : Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ忡 �����ϴ� ������̼�
	// => @Bean ������̼��� ����� �޼ҵ尡 ��ȯ�� ��ü�� ������ �����̳ʿ� ���� ���� - Spring Bean
	// => Spring Bean Configuration File�� bean ������Ʈ�� ������ ����� �����ϴ� ������̼�
	// => �޼ҵ��� �̸��� Spring Bean�� �ĺ���(beanName)���� ���
	// => @Bean ������̼��� name �Ӽ��� �̿��Ͽ� �ĺ���(beanName) ���� ����
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
	
	/*
	@Bean
	public ComponentAnnotationBean componentAnnotationBean() {
		return new ComponentAnnotationBean();
	}
	*/
}