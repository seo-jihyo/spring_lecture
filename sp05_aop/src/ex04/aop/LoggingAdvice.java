package ex04.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/*XML ��� POJO����� AspectJ�� �̿��� AOP ���*/
public class LoggingAdvice {

	/*
	 * Around ����� ����/���� ó�� AOP around ������� �Ҷ��� �μ��� ProceedingJoinPoint, ���� - Object �ʼ�
	 */
	public Object around(ProceedingJoinPoint point) throws Throwable {
		String methodName = point.getKind();
		String methodName2 = point.getSignature().getName();

		System.out.println("[LOG] methodName: " + methodName + ", methodName2 = " + methodName2 + "ȣ��Ǳ� ��...");

		StopWatch sw = new StopWatch();
		sw.start(methodName);

		//////////////�� ���� ���� �ڵ� //////////////
		Object obj = point.proceed();	//���� Ÿ�� ��� �޼ҵ尡 ȣ��Ǵ� �κ� 
		//////////////////////////////////////////

		System.out.println("[LOG]" + methodName2 + "ȣ�� �Ϸ� �Ǿ����ϴ�.");
		System.out.println("[LOG] ���� �ð�: " + sw.getTotalTimeMillis()/1000 + "��");
		
		return obj;
	}

}
