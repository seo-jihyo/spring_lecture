package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service //service bean으로 등록
public class ShaEncoder {
	// security-context.xml에 선언된 passwordEncoder bean 주입
	
	//@Resource(name="passwordEncoder") 로 autowired와 qualifier을 대신할 수 있다.
	@Autowired
	@Qualifier("passwordEncoder")
	ShaPasswordEncoder encoder;
	//인자값을 넘겨받아서 
	
	//암호화시켜주는 함수
	public String encoding(String str) {
		return encoder.encodePassword(str, null);
	}
	//security-context의 salt-source
	public String saltEncoding(String str, String salt) {
		return encoder.encodePassword(str, salt);
	}
}





