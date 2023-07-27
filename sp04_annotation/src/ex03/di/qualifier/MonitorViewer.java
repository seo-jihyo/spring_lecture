package ex03.di.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MonitorViewer {
	
	private Recorder recorder; //has-a

	//constructor method - DI
//	@Inject
//	@Autowired(required = false)
//	public MonitorViewer(@Qualifier("key" )Recorder recorder) {
//		super();
//		this.recorder = recorder;
//		System.out.println("@Autowired 자동 주입");
//	}
	
	
//	@Autowired
////	@Qualifier("recorder1") //id = "recorder1"
//	@Qualifier("key")
//	public void setRecorder(Recorder recorder) {
//		this.recorder = recorder;
//	}
//	

	public void setRecorder(@Qualifier("code") Recorder recorder) {
		this.recorder = recorder;
	}
	
	public void show() {
		recorder.show();
		System.out.println("MonitorViewer class show method call~ ");
		System.out.println("setter method MonitorViewer class show method call~ ");
	}

}
