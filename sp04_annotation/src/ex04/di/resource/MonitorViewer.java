package ex04.di.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	private Recorder recorder; //has-a
	
	@Resource	//name 지정 안할 때는 qualifier 함께 적용
//	@Resource(name = "record2")	//name값
//	@Resource(name = "x")	//name값
//	@Resource(name = "r3") //id

	public void setRecorder(@Qualifier("y")Recorder recorder) {	//DI
		this.recorder = recorder;
		
		boolean record = Resource.class.getTypeName().contains("record1");
		System.out.println(record);
		
		System.out.println(Resource.class.getTypeName().equals("record1"));
		System.out.println(Resource.class.getCanonicalName().equals("record1"));
		
		System.out.println(Resource.AuthenticationType.class);
		recorder.show();
		System.out.println(recorder);
		System.out.println("@Resource 주입");
	}
	
	
}
