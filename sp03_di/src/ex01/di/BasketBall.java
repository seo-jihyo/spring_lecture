package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BasketBall {

	@Autowired  //자동 주입된다.
	private PlayerImpl  player;

	public void setPlayer(PlayerImpl player) {  // DI
		this.player = player;
	}
	
}
