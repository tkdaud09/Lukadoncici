package xyz.itwill07.aop;

public class ExecutionTimeBean {
	public void one() {
		//System.currentTimeMillis() : �ý����� ���� ��¥�� �ð��� ���� Ÿ�ӽ������� ��ȯ�ϴ� �޼ҵ�
		//Ÿ�ӽ�����(TimeStamp) : ��¥�� �ð��� ���� ������ �������� ��¥�� �ð��� ���������� ��ȯ�� �� 
		//long startTime=System.currentTimeMillis();
		
		long count=0;
		for(long i=1;i<=10000000000L;i++) {
			count++;
		}
		System.out.println("count = "+count);

		//long endTime=System.currentTimeMillis();
		//System.out.println("ExecutionTimeBean Ŭ������ one() �޼ҵ� ���� �ð� = "+(endTime-startTime)+"ms");
	}
	
	public void two() {
		//long startTime=System.currentTimeMillis();

		long count=0;
		for(long i=1;i<=20000000000L;i++) {
			count++;
		}
		System.out.println("count = "+count);

		//long endTime=System.currentTimeMillis();
		//System.out.println("ExecutionTimeBean Ŭ������ two() �޼ҵ� ���� �ð� = "+(endTime-startTime)+"ms");
	}
}