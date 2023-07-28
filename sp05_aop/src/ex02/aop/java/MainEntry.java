package ex02.aop.java;

import java.lang.reflect.Proxy;

public class MainEntry {
	public static void main(String[] args) {
		ICalc c = new CalcImpl();
		
		ICalc proxy = (ICalc)Proxy.newProxyInstance(
											 c.getClass().getClassLoader(),				// loader: 클래스 찾기 
											 c.getClass().getInterfaces(), 				// interfaces: 행위(함수)
											 new LogprintHandlerImpl(c));				// h: 보조 업무 구현
		
//		Proxy를 통해서 실행
		System.out.println(proxy.add(2, 5));
		System.out.println(proxy.mul(3, 5));
		System.out.println(proxy.sub(10, 3, 2));
		
//		클래스 통해서 실행
//		System.out.println(c.add(1, 2));
//		System.out.println(c.add(10, 22));
//		System.out.println();
//		System.out.println(c.mul(3, 5)); 
	}
	
}
