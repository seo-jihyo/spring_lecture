package ex00.aop.annot.prc;

import lombok.Setter;

@Setter
public class Worker {
	private String name;
	private int age;
	private String job;
	
	public void getWorkerInfo() {
		System.out.println("�̸�: " + this.name);
		System.out.println("����: " + this.age);
		System.out.println("����: " + this.job);
	}
}
