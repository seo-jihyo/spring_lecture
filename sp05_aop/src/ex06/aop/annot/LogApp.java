package ex06.aop.annot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//<aop:pointcut expression="execution( public void ex04.aop.*.*Hello(..) )" id="pointCut"/>�� annotation����

@Aspect
public class LogApp {		// Advice class - Around(type) ����

	@Pointcut("execution(public void get*(..))")	//pattern	
	public void pointCutMethod() { }
	
	@Around("pointCutMethod()") //������ ������ �ִ� �޼ҵ� �̸��� �ݵ�� �����Ѵ�.
	public Object loggerApp(ProceedingJoinPoint point) throws Throwable{
		String signatureStr = point.getSignature().toLongString();
		System.out.println(signatureStr + "is Start........");
		System.out.println("arround advice");
		long st = System.currentTimeMillis();
		
		Object obj = point.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(signatureStr + " is Finished");
		System.out.println(signatureStr + "����ð�: " + (end - st));
		
		return obj;
	}
	
	@Before("pointCutMethod()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice");
		System.out.println("���а� �Ի縦 �����մϴ�.");
	}
}
