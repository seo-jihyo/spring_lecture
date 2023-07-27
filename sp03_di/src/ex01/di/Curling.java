package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Curling {

	
	private PlayerImpl  player;

	@Autowired(required = true) //default false, �ݵ�� ����ؾ� �� ��� true
	//@Qualifier("m2")
	public void setPlayer(PlayerImpl player) {  // DI
		this.player = player;
	}
}
