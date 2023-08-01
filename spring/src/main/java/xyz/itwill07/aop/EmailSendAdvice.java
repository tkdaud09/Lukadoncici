package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

//Ⱦ�ܰ��ɸ�� - Advice Ŭ����
@Slf4j
public class EmailSendAdvice {
	//���� ���� ���� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - Before Advice Method
	// => �޴� ����� �̸��� �ּҿ� ������ �����޾� �α� ���Ͽ� ���
	public void accessLog(JoinPoint joinPoint) {
		//Ÿ�ٸ޼ҵ��� �Ű��������� �޴� ����� �̸��� �ּҸ� �����޾� ����
		String email=(String)joinPoint.getArgs()[0];
		//Ÿ�ٸ޼ҵ��� �Ű��������� ���� ������ �����޾� ����
		String subject=(String)joinPoint.getArgs()[1];
		log.info(email+"�Կ��� <"+subject+"> ������ �̸����� �����մϴ�.");
	
	}
	
	//���� ���� ���� �Ŀ� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - After Returning Advice Method
	// => �޴� ����� �̸��� �ּҸ� Ÿ�ٸ޼ҵ��� ��ȯ������ �����޾� ��ϵǴ� ��� �ۼ�
	public void successLog(String email) {
		log.info(email+"�Կ��� �̸����� ���������� ���� �Ͽ����ϴ�.");
	}
	
	//���� ���� ���� �Ŀ� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - After Throwing Advice Method
	// => ���� ���� ���п� ���� �޼����� Ÿ�ٸ޼ҵ��� ���ܷκ��� �����޾� ����ϴ� ��� �ۼ�
	public void errorLog(Exception exception) {
		log.info("�̸��� ���� ���� = "+exception);
	}
}
