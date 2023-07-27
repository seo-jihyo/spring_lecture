package springConfig;

public class Client2 {
	private String host;

	public void setHost(String host) {	 //DI
		this.host = host;
	}

	public void connect() throws Exception{
		System.out.println("Client2.connect() 실행 - 초기화 메서드");
	}
	
	public void send() {
		System.out.println("Client2.snd() call: " + host);
	}
	
	public void close() throws Exception{
		System.out.println("Client2.close() call - 소멜 메서드");
	}
}
