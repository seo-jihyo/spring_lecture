package ex04.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext context = 
			//	new ClassPathXmlApplicationContext("ex04/di/appCtx.xml");
//				new ClassPathXmlApplicationContext("appCtx.xml");
		new ClassPathXmlApplicationContext(new String[]{"appCtx.xml","test.xml"});
				
		
		IRecordViewImpl view = context.getBean("view", IRecordViewImpl.class);
//		IRecordViewImpl view = (IRecordViewImpl) context.getBean("view"); 형변환해서 써도 ok
		view.print();
	}
	/*	IRecordImpl record = new IRecordImpl()
				
		IRecordViewImpl view = new IRecordViewImpl();
		
		//조립
		view.setRecord(record);
		view.input();
		view.print();
	}*/
		
}
