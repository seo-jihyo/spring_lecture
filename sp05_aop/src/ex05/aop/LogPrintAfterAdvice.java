package ex05.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class LogPrintAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(
								Object returnValue, 
								Method method, 
								Object[] args, 
								Object target
								) throws Throwable {
		
		System.out.println("AfterReturningAdvice");
		Log log = LogFactory.getLog(this.getClass());//������ġ Ŭ������
		log.info("[�־��� ����ǰ� ���ƿͼ� �ٷ� ����]");
		System.out.println("[AfterReturning Method]: " + method.getModifiers());
		System.out.println("[Return Value]: " + returnValue);
		System.out.println("[args Value]: " + Arrays.toString(args));
	}
	
}
