package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Soccor {
	
	@Autowired
	private PlayerImpl player;

	public void setPlayer(PlayerImpl player) {
		this.player = player;
	}
}
