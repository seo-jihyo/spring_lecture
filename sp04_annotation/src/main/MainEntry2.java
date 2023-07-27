package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfig;
import config.JavaConfigPrototype;
import springConfig.Client2;

public class MainEntry2 {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		ApplicationContext ctx = new GenericXmlApplicationContext("config/appCtx2.xml");
	
		Client2 client = ctx.getBean("client2", Client2.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		client.send();
		
		System.out.println(client.hashCode());
		System.out.println(client2.hashCode());
		((AbstractApplicationContext) ctx).close();
		
	}
}
