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
			Log log = LogFactory.getLog(this.getClass());//현재위치 클래스에
			log.info("[Method Before Advice] 보조 업무 구현 (주업무 시작 전)");
					
		
	}

	
}
