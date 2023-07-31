package ex06.aop.annot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//<aop:pointcut expression="execution( public void ex04.aop.*.*Hello(..) )" id="pointCut"/>�� annotation����

@Aspect
public class LogApp { // Advice class - Around(type) ����

	@Pointcut("execution(public void get*(..))") // pattern
	// @Pointcut("execution(public void get*(..))") // public void�� ��� get�޼ҵ�
	// @Pointcut("execution(* ex06.aop.annot.*.*())") // kr.edu.kosta ��Ű���� �Ķ���Ͱ� ����
	// ��� �޼ҵ�
	// @Pointcut("execution(* kr.edu.kosa..*.*())") // kr.edu.kosta ��Ű�� &
	// kr.edu.kosta ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
	// @Pointcut("execution(* kr.edu.kosta.Worker.*())") // kr.edu.kosta.Worker ����
	// ��� �޼ҵ�

	// @Pointcut("within(ex06.aop.annot.*)") //kr.edu.kosta ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
	// @Pointcut("within(ex06.aop.annot..*)") //kr.edu.kosta ��Ű�� �� ���� ��Ű�� �ȿ� �ִ� ���
	// �޼ҵ�
	// @Pointcut("within(ex06.aop.annot.Worker)") //kr.edu.kosta.Worker ��� �޼ҵ�

	// @Pointcut("bean(student)") //student �󿡸� ����
	// @Pointcut("bean(*ker)") //~ker�� ������ �󿡸� ����
	// @Pointcut("!bean(student)") // student ���� �����ѰͿ� ���� -> worker��
	public void pointCutMethod() {
	}

	@Around("pointCutMethod()") // ������ ������ �ִ� �޼ҵ� �̸��� �ݵ�� �����Ѵ�.
	public Object loggerApp(ProceedingJoinPoint point) throws Throwable {
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
