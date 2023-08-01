package xyz.itwill07.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@Aspect : �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ带 �����Ͽ� �����ϱ� ���� ����� �����ϴ� ������̼�
// => Spring Bean Configuration File�� aspect ������Ʈ�� ������ ��� ����
@Aspect
public class AopAnnotationAdvice {
	//@Pointcut : Ÿ�ٸ޼ҵ带 �����ϱ� ���� ������̼�
	// => �޼ҵ带 ȣ���Ͽ� Pointcut ǥ�������� ������ Ÿ�ٸ޼ҵ带 �����޾� �޾� ���
	// => Spring Bean Configuration File�� pointcut ������Ʈ�� ������ ��� ����
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Pointcut("within(xyz.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
	//@Before : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼� 
	// => Spring Bean Configuration File�� before ������Ʈ�� ������ ��� ����
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => @Pointcut ������̼��� ����� �޼ҵ� ȣ���Ͽ� Pointcut ǥ������ ���� �޾� ��� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	//@Before("within(xyz.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		log.info("[before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
}