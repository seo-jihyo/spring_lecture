package ex03.di;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor //»ý¼ºÀÚ
@Data
public class EmployeePersonImpl implements Person {

	private String name, gender;
	private int age;
	private ArrayList<Integer> hobby;
	
	@Override
	public boolean personShow(String name, int age, String gender) {
		System.out.println(name + "/" + age + "/" + gender);
		return true;
	}

	@Override
	public boolean personShow(Person person) {
		System.out.println(person);
		return true;
	}
	public boolean personShow(ArrayList<Integer> hobby) {
		for (int i = 0; i < hobby.size(); i++) {
			System.out.println(hobby);
		}
		return true;
	}
}
