package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfig;
import springConfig.Client;

public class MainEntry {
	public static void main(String[] args) {
	
		ApplicationContext ctx = new GenericXmlApplicationContext("config/appCtx.xml");
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Client c = ctx.getBean("client", Client.class);
		c.setHost("º≠πˆæﬂ!!");
		c.send();
		
		Client c2 = ctx.getBean("client", Client.class);
		c2.setHost("defaultHost");
		c2.send();
		
		//spring¿∫ ΩÃ±€≈Ê ∆–≈œ¿”
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		
//		ctx.close();
	}
}
