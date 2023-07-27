package springConfig;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

	private String defaulthost;
	private String host;
	
	//setter DI
	public void setDefaulthost(String defaulthost) {
		this.defaulthost = defaulthost;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void send() { 		/* <property name="host" value="����" /> */
		System.out.println("Client.send() to: " + host);
	}
	//constructor DI
	public Client() {
		System.out.println("Client Default Constructor");
	}
	public Client(String defaulthost) {
		super();
		this.defaulthost = defaulthost;
		System.out.println("Client ������: " + this.defaulthost);
	}

	//�ʱ�ȭ �޼���(�̺�Ʈ�� ���������� ������ �ڵ� ȣ��: ȣ�� ����)
	//InitializingBean�� ���� ������
	//afterPropertiesSet:property injection�Ŀ�
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet()����");
	}

	// �Ҹ� �޼��� (�̺�Ʈ�� ���������� ������ �ڵ� ȣ��: ȣ�� ����)
	// DisposableBEan �� ���� ������
	@Override
	public void destroy() throws Exception { // ctx.close();
		System.out.println("Client.destory() ����");
	}
}
