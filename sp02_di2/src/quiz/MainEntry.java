package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("quiz/appCtx.xml");

		IMessageImpl helloKor = (IMessageImpl) context.getBean("kor");
		IMessageImpl2 helloEng = (IMessageImpl2) context.getBean("eng");

		helloKor.sayHello();
		helloEng.sayHello();
	}
}
