package ex05.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("ex05/aop/appCtx.xml");
		
		ICalc proxyCCal = (ICalc) ctx.getBean("proxy");
		System.out.println(proxyCCal.add(11, 22));
		System.out.println(proxyCCal.add(11, 2));
		System.out.println(proxyCCal.sub(10, 2, 3));
		System.out.println("------------------------");
	}
}
