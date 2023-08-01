package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

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
	
	//After Returning Advice Method���� JoinPoint �������̽��� �Ű����� �ܿ� Object Ŭ������ �Ű����� ���� ����
	// => ������ �����̳ʴ� Object Ŭ������ �Ű������� Ÿ�ٸ޼ҵ��� ��ȯ���� �����޾� ����
	// => Ÿ�ٸ޼ҵ忡�� ��ȯ�Ǵ� ��(��ü)�� �ڷ����� �����Ǿ� �ִ� ��� Object Ŭ���� ���
	//��ȯ�Ǵ� ��(��ü)�� �ڷ������� �Ű����� �ۼ� ����
	// => Object Ŭ������ �Ű������� ����� ��� Spring Bean Configuration File�� AOP ��������
	//after-returning ������Ʈ�� �ݵ�� returning �Ӽ��� ����Ͽ� ��ȯ���� ������ �Ű�������
	//�̸��� �Ӽ������� ����
	// => after-returning ������Ʈ�� returning �Ӽ��� ���ų� �Ӽ����� �߸��� ��� IllegalArgumentException �߻�

	//After Returning Advice Method
	public void displayName(JoinPoint joinPoint, Object object) {
		//System.out.println("### [after-returning]�ٽɰ����ڵ尡 ���������� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		
		String methodName=joinPoint.getSignature().getName();
		String userName=(String)object;
		System.out.println("### [after-returning]"+methodName+" �޼ҵ��� ��ȯ�� = "+userName);
	}

	//After Throwing Advice Method���� JoinPoint �������̽��� �Ű����� �ܿ� Exception Ŭ������ �Ű����� ���� ����
	// => ������ �����̳ʴ� Exception Ŭ������ �Ű������� Ÿ�ٸ޼ҵ忡�� �߻��� ����(Exception ��ü)�� �����޾� ����
	// => Ÿ�ٸ޼ҵ忡�� �߻��Ǵ� ���ܰ� �����Ǿ� �ִ� ��� Exception Ŭ���� ��� �ʿ��� ����
	//Ŭ������ �Ű����� �ۼ� ����
	// => Exception Ŭ������ �Ű������� ����� ��� Spring Bean Configuration File�� AOP ��������
	//after-throwing ������Ʈ�� �ݵ�� throwing �Ӽ��� ����Ͽ� �߻��� ���ܸ� �����ϱ� ����
	//�Ű������� �̸��� �Ӽ������� ����
	// => after-returning ������Ʈ�� throwing �Ӽ��� ���ų� �Ӽ����� �߸��� ��� IllegalArgumentException �߻�
	
	//After Throwing Advice Method
	public void exceptionHandle(JoinPoint joinPoint, Exception exception) {
		//System.out.println("### [after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��� ��� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		
		String methodName=joinPoint.getSignature().getName();

		System.out.println("### [after-throwing]"+methodName+" �޼ҵ忡�� �߻��� ���� = "
				+exception.getMessage());
	}

	//Around Advice Method�� ��ȯ���� Object Ŭ������ �ۼ��ϰ� �Ű������� ProceedingJoinPoint
	//�������̽��� �ۼ��Ͽ� ����
	// => Ÿ�ٸ޼ҵ��� ��ȯ���� �����޾� ��ȯ ó���ϱ� ���� Object Ŭ������ ��ȯ�� �ۼ�
	// => Ÿ�ٸ޼ҵ� ���� ������ ProceedingJoinPoint �������̽��� �Ű������� �����޾�
	//Around Advice Method���� ���
	//ProceedingJoinPoint ��ü : Ÿ�ٸ޼ҵ� ���� ������ �����ϱ� ���� ��ü
	// => JoinPoint ��ü�� �ٸ����� Ÿ�ٸ޼ҵ带 ���� ȣ���ϱ� ���� �޼ҵ� ����
	
	//Around Advice Method
	public Object display(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("### [around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		//ProceedingJoinPoint.proceed() : Ÿ�ٸ޼ҵ带 ȣ���ϴ� �޼ҵ� - �ٽɰ����ڵ� ����
		// => Ÿ�ٸ޼ҵ带 ȣ���Ͽ� ��ȯ�Ǵ� ������� ������ ����
		// => Throwable(Error Ŭ������ Exception Ŭ������ �θ�Ŭ����) ��ü�� �߻��ǹǷ� �ݵ��
		//���� ó���ϰų� ���� ����
		Object result=joinPoint.proceed();
		System.out.println("### [around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		return result;//Ÿ�ٸ޼ҵ��� ��ȯ���� ��ȯ ó��
	}
}
