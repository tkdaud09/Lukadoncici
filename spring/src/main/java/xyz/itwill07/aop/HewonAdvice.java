package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//Ⱦ�ܰ��ɸ��(CrossCutting Concern Module) : Ⱦ�ܰ����ڵ�� �ۼ��� �޼ҵ尡 ����� Ŭ���� - Advice Ŭ����
// => Ⱦ�ܰ����ڵ� : ����Ÿ ó�� ����� ������ �������� ����� �����ϴ� ���
// => �α� ó��, ����(����) ó��, Ʈ������ ó��, ���� ó�� ���� ���
public class HewonAdvice {
	//Ÿ�ٸ޼ҵ��� ��� �������� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - Before Advice Method
	// => JoinPoint : �ٽɰ����ڵ带 �������� Ⱦ�ܰ����ڵ尡 ���ԵǾ� ���۵� ��ġ�� ǥ��
	//Ÿ�ٸ޼ҵ�(Target Method) : �ٽɰ��ɸ���� �޼ҵ� �� PiuntCut ǥ�������� �����Ǿ� 
	//Ⱦ�ܰ����ڵ尡 ���Ե� �޼ҵ�
	// => PiuntCut ǥ���� : �ٽɰ��ɸ���� �޼ҵ� �� Ư�� �޼ҵ常 �����ϱ� ���� ���
	public void beforeLog() {
		System.out.println("### [before]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	//Ÿ�ٸ޼ҵ��� ����� ����� �� ������ ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - After Advice Method
	public void afterLog() {
		System.out.println("### [after]�ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	//Ÿ�ٸ޼ҵ��� ����� ���������� ����� �� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - After Returning Advice Method
	public void afterReturningLog() {
		System.out.println("### [after-returning]�ٽɰ����ڵ尡 ���������� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	//Ÿ�ٸ޼ҵ��� ��� ����� ���� �߻��� �� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - After Throwing Advice Method
	public void afterThrowingLog() {
		System.out.println("### [after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��� ��� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	//Ÿ�ٸ޼ҵ��� ��� ���� ���� �Ŀ� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - Around Advice Method
	public void aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("### [around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		joinPoint.proceed();//Ÿ�ٸ޼ҵ� ȣ�� - �ٽɰ����ڵ� ����
		System.out.println("### [around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
}












