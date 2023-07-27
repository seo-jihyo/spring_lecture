package ex01.annot;

import lombok.AllArgsConstructor;

@AllArgsConstructor			// DI
public class Cats {

	private MyCats myCats;
	
	public void setMyCatsInfo(MyCats myCats) {
		this.myCats = myCats;
	}
	
	//출력함수
	public void getMyCatsInfo() {
		System.out.println("********************************");
		System.out.println("cats Name: " + myCats.getName());
		System.out.println("cats Age: " + myCats.getAge());
		System.out.println("cats Color: " + myCats.getColor());
		System.out.println("cats Weight: " + myCats.getWeight());
		System.out.println("cats Hobbys: " + myCats.getHobbys());
		System.out.println("********************************");
	}
}
