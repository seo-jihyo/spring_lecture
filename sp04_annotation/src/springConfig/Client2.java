package springConfig;

public class Client2 {
	private String host;

	public void setHost(String host) {	 //DI
		this.host = host;
	}

	public void connect() throws Exception{
		System.out.println("Client2.connect() ���� - �ʱ�ȭ �޼���");
	}
	
	public void send() {
		System.out.println("Client2.snd() call: " + host);
	}
	
	public void close() throws Exception{
		System.out.println("Client2.close() call - �Ҹ� �޼���");
	}
}
