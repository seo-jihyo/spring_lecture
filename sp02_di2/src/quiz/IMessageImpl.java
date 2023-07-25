package quiz;

public class IMessageImpl implements IMessage {
	 
	private String hello;
	
	@Override
	public void sayHello() {
		System.out.println(this.hello);
	}
	public IMessageImpl() {
		
	}
	public IMessageImpl(String hello) {
		this.hello = hello;
	}
}
