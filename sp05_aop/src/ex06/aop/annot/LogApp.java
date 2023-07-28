package ex06.aop.annot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//<aop:pointcut expression="execution( public void ex04.aop.*.*Hello(..) )" id="pointCut"/>을 annotation으로

@Aspect
public class LogApp {		// Advice class - Around(type) 적용

	@Pointcut("execution(public void get*(..))")	//pattern	
	public void pointCutMethod() { }
	
	@Around("pointCutMethod()") //패턴을 가지고 있는 메소드 이름을 반드시 기재한다.
	public Object loggerApp(ProceedingJoinPoint point) throws Throwable{
		String signatureStr = point.getSignature().toLongString();
		System.out.println(signatureStr + "is Start........");
		System.out.println("arround advice");
		long st = System.currentTimeMillis();
		
		Object obj = point.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(signatureStr + " is Finished");
		System.out.println(signatureStr + "경과시간: " + (end - st));
		
		return obj;
	}
	
	@Before("pointCutMethod()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice");
		System.out.println("입학과 입사를 축하합니다.");
	}
}
