package ex06.aop.annot;

import lombok.Setter;

@Setter	//DI
public class Student {
	private String name;
	private int age, gradeNum, classNum;

	public void getStudentInfo() {
		System.out.println("�̸�: " + this.name);
		System.out.println("����: " + this.age);
		System.out.println("�г�: " + this.gradeNum);
		System.out.println("��: " + this.classNum);
	}
}
