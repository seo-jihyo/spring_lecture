package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service //service bean���� ���
public class ShaEncoder {
	// security-context.xml�� ����� passwordEncoder bean ����
	
	//@Resource(name="passwordEncoder") �� autowired�� qualifier�� ����� �� �ִ�.
	@Autowired
	@Qualifier("passwordEncoder")
	ShaPasswordEncoder encoder;
	//���ڰ��� �Ѱܹ޾Ƽ� 
	
	//��ȣȭ�����ִ� �Լ�
	public String encoding(String str) {
		return encoder.encodePassword(str, null);
	}
	//security-context�� salt-source
	public String saltEncoding(String str, String salt) {
		return encoder.encodePassword(str, salt);
	}
}





