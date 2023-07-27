package ex01.annot;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {	//xml ���� ���� ���� ex) ctx.xml , appCtx.xml, ...

	@Bean
	public MyCats cat1() {	//	MyCats cat1 = new MyCats();		/	<bean id = "cat1" class=e01.annot.java.MyCat" />
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("�߱���");
		hobbys.add("�����ϱ�");
		
		MyCats myCats = new MyCats("����", 3, hobbys);
		myCats.setWeight(3.0);
		myCats.setColor("yellow");
		
		return myCats;
	}
	@Bean
	public MyCats cat2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("��ũ�ϱ�");
		hobbys.add("���ڱ�");
		
		MyCats myCats = new MyCats("����", 5, hobbys);
		myCats.setWeight(2.3);
		myCats.setColor("white");
		
		return myCats;
		
	}
	@Bean
	public Cats catsInfo() {
		Cats cats = new Cats(this.cat1());	//ref = "emplyee"�� ����
		return cats;
	}
}
