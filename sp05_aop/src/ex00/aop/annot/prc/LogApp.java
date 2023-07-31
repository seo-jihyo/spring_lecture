package ex00.aop.annot.prc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LogApp {
	@Pointcut("execution(public void get*(..))")
	
	public void pointCutMethod() {
		
	}
	@Around("pointCutMethod()")
	public Object loggerApp(ProceedingJoinPoint point) throws Throwable{
		String signatureStr = point.getSignature().toLongString();
		System.out.println(signatureStr + "is Start...");
		System.out.println("arround advice");
		long st = System.currentTimeMillis();
		
		Object obj = point.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(signatureStr + "is Finished");
		System.out.println(signatureStr + "경고시간: " + (end - st));
		
		return obj;
	}
	@Before("pointCutMethod()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice");
		System.out.println("입학과 입사를 축하합니다.");
	}
}
