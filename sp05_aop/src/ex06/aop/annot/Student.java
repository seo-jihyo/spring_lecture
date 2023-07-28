package ex06.aop.annot;

import lombok.Setter;

@Setter	//DI
public class Student {
	private String name;
	private int age, gradeNum, classNum;

	public void getStudentInfo() {
		System.out.println("이름: " + this.name);
		System.out.println("나이: " + this.age);
		System.out.println("학년: " + this.gradeNum);
		System.out.println("반: " + this.classNum);
	}
}
