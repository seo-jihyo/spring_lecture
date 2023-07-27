package ex01.annot;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {	//xml 설정 파일 역할 ex) ctx.xml , appCtx.xml, ...

	@Bean
	public MyCats cat1() {	//	MyCats cat1 = new MyCats();		/	<bean id = "cat1" class=e01.annot.java.MyCat" />
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("뒹굴기");
		hobbys.add("세수하기");
		
		MyCats myCats = new MyCats("망고", 3, hobbys);
		myCats.setWeight(3.0);
		myCats.setColor("yellow");
		
		return myCats;
	}
	@Bean
	public MyCats cat2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("윙크하기");
		hobbys.add("잠자기");
		
		MyCats myCats = new MyCats("나비", 5, hobbys);
		myCats.setWeight(2.3);
		myCats.setColor("white");
		
		return myCats;
		
	}
	@Bean
	public Cats catsInfo() {
		Cats cats = new Cats(this.cat1());	//ref = "emplyee"와 같음
		return cats;
	}
}
