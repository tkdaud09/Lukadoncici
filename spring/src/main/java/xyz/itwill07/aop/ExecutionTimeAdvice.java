package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	//Ÿ�ٸ޼ҵ��� ����� ����Ǵ� ó���ð��� ����Ͽ� ����ϱ� ���� �޼ҵ� - Around Advice Method
	/*
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�ٸ޼ҵ��� ��� �������� ���۵� ��� �ۼ�
		long startTime=System.currentTimeMillis();
		
		//Ÿ�ٸ޼ҵ��� ��� ���� - Ÿ�ٸ޼ҵ� ȣ��
		Object returnValue=joinPoint.proceed();
		
		//Ÿ�ٸ޼ҵ��� ��� �����Ŀ� ���۵� ��� �ۼ�
		long endTime=System.currentTimeMillis();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		System.out.println(className+" Ŭ������ "+methodName+"() �޼ҵ� ���� �ð� = "
				+(endTime-startTime)+"ms");
		
		return returnValue;
	}
	*/
	
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�ٸ޼ҵ��� ��� �������� ���۵� ��� �ۼ�
		//StopWatch ��ü : �ð��� �����ϱ� ���� ����� �����ϱ� ���� ��ü
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.start();
		
		//Ÿ�ٸ޼ҵ��� ��� ���� - Ÿ�ٸ޼ҵ� ȣ��
		Object returnValue=joinPoint.proceed();
		
		//Ÿ�ٸ޼ҵ��� ��� �����Ŀ� ���۵� ��� �ۼ�
		//StopWatch.stop() : �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.stop();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		//StopWatch.getTotalTimeMillis() : �ð� ���� ����� ms ������ ��ȯ�ϴ� �޼ҵ�
		System.out.println(className+" Ŭ������ "+methodName+"() �޼ҵ� ���� �ð� = "
				+stopWatch.getTotalTimeMillis()+"ms");
		
		return returnValue;
	}
}