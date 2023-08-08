package ex02.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoniterViewer {

	//1. �ʵ忡 ����
//	@Autowired
	private Recorder recorder;	//has-a

	public Recorder getRecorder() {
		return recorder;
	}

	//2. setter method �� ���� �ڵ� ����
//	@Autowired
//	public void setRecorder(Recorder recorder) {
//		this.recorder = recorder;
//	}
	//3. �Ϲ� �޼ҵ�
	@Autowired
	public void userMethod(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("�����(�Ϲ�) �޼ҵ� �̿��� �ڵ� ����");
	}
	
	//4. ������ �Լ��� �̿��� ����
//	public MoniterViewer(Recorder recorder) {
//		super();
//		this.recorder = recorder;
//		System.out.println("������ �Լ� �̿��� �ڵ� ����");
//	}

	public void print() {
		System.out.println("user method ����: " + this.recorder);
		System.out.println("setter method");
		recorder.show();
	}
	
}