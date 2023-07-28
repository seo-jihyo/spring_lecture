package ex05.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class LogPrintBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {

			System.out.println("Before Advice Start");
			Log log = LogFactory.getLog(this.getClass());//������ġ Ŭ������
			log.info("[Method Before Advice] ���� ���� ���� (�־��� ���� ��)");
					
		
	}

	
}
