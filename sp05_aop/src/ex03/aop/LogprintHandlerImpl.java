package ex03.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogprintHandlerImpl implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("invoke method start..........................");
		
		//보조 업무
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간측정 시작
		log.info("타이머 시작");
		//////////////주 관심 실행 코드 //////////////
		Object result = invocation.proceed();
		//////////////////////////////////////////
		sw.stop(); // 시간측정 끝
		log.info("타이머 정지");

		log.info("[TimerLog] Method: " + invocation.getMethod());	//실행한 메소드 명칭
		log.info("[TimerLog] process Time: " + sw.getTotalTimeMillis()); // 작업에 걸린 시간
		
		return result;
	}

}
