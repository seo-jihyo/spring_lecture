package quiz;

import lombok.Setter;

@Setter
public class IMessageImpl2 implements IMessage {
	 
	private String hello;
	
	public IMessageImpl2() {
		
	}

	
	@Override
	public void sayHello() {
		System.out.println(this.hello);
		
	}
}
