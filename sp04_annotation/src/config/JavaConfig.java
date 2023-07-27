package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springConfig.Client;

@Configuration //������������ �˷���
public class JavaConfig {	//xml ��� ������ �ƴ� �ڹ� ��� ����
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("server@@");
		return client;
	}

}
