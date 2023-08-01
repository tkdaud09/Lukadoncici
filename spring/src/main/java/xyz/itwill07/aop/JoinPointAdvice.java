package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//Ⱦ�ܰ��ɸ�� - Advice Ŭ����
public class JoinPointAdvice {
	//Around Advice Method�� ������ ������ Advice Method�� �Ϲ������� ��ȯ���� [void]�� �ۼ��ϰ�
	//�Ű������� �ۼ����� �ʰų� JoinPoint �������̽��� �ڷ������� ����� �Ű����� ���� ����
	// => Advice Ŭ������ �޼ҵ带 �ۼ� ��Ģ�� ���� �ʰ� �ۼ��� ��� IllegalArgumentException �߻�
	//JoinPoint ��ü : Ÿ�� �޼ҵ� ���� ������ ����� ��ü
	// => ������ �����̳ʰ� Advice Ŭ������ �޼ҵ带 ȣ���� �� Ÿ�� �޼ҵ� ���� ������ ������
	//JoinPoint ��ü�� �����Ͽ� �Ű������� ����
	// => Advice Ŭ������ �޼ҵ忡�� Ÿ�� �޼ҵ� ���� ������ �ʿ��� ��� �Ű������� �����Ͽ� 
	//JoinPoint ��ü�� ���޹޾� �޼ҵ带 ȣ���Ͽ� �ʿ��� ������ ��ȯ�޾� ��� ����
	
	//Before Advice Method
	public void beforeDisplay(JoinPoint joinPoint) {
		//System.out.println("### [before]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		
		//JoinPoint.getTarget() : Ÿ�� �޼ҵ带 ȣ���� ��ü(�ٽɰ��ɸ���� Spring Bean)�� ��ȯ�ϴ� �޼ҵ�
		//Object.getClass() : ��ü�� ������ Ŭ������ Class ��ü(Clazz)�� ��ȯ�ϴ� �޼ҵ�
		//Class.getName() : Class ��ü�� ����� Ŭ������ �̸�(��Ű�� ����)�� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getTarget().getClass().getName());
		
		//Class.getSimpleName() : Class ��ü�� ����� Ŭ������ �̸�(��Ű�� ����)�� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getTarget().getClass().getSimpleName());

		//JoinPoint.getSignature() : Ÿ�� �޼ҵ��� ������ ����� Signature ��ü�� ��ȯ�ϴ� �޼ҵ�
		//Signature.getName() : Ÿ�� �޼ҵ��� �̸��� ��ȯ�ϴ� �޼ҵ� 
		//System.out.println(joinPoint.getSignature().getName());
		
		//JoinPoint.getArgs() : Ÿ�� �޼ҵ��� �Ű������� ����� ��� ��(��ü)�� �����޾� 
		//Object �迭�� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getArgs());
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		Object[] params=joinPoint.getArgs();
		
		System.out.print("### [before]"+className+" Ŭ������ "+methodName+"(");
		for(int i=0;i<params.length;i++) {
			System.out.print(params[i]);
			if(i < params.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(") �޼ҵ� ȣ�� ###");
	}

	//After Advice Method
	public void displayMessage(JoinPoint joinPoint) {
		//System.out.println("### [after]�ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		
		Object[] params=joinPoint.getArgs();
		System.out.println("### [after]�����ȣ�� "+params[0]+"�� ��������� ���� �Ͽ����ϴ�. ");
	}
}










