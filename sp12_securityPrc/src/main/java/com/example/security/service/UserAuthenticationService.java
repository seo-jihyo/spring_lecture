package com.example.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.security.model.dto.UserDTO;
//�α��� ó�� Ŭ����
public class UserAuthenticationService implements UserDetailsService {

//	@Autowired �ɸ� ������ �ۼ��� �ʿ����
	private SqlSessionTemplate sqlSession;	//db����
	
	public UserAuthenticationService() { 	} //default ������
	
	public UserAuthenticationService(			//���ڰ� �ִ� ������
			SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userid) 
			throws UsernameNotFoundException {
		//����� ���̵� Ȯ��, mapper�� �̸��� �����.
		Map<String,Object> user=sqlSession.selectOne("user.selectUser", userid);	
		//���̵� ������ ���� �߻�
		if(user==null) throw new UsernameNotFoundException(userid);
		
		//������ ���
		List<GrantedAuthority> authority= new ArrayList<>();
		authority.add(new SimpleGrantedAuthority(user.get("AUTHORITY").toString())); //�ʵ���� �빮�ڷ�
		return new UserDTO(user.get("USERNAME").toString(),
								user.get("PASSWORD").toString(),
								true,
								true,true,true,authority,
								user.get("USERNAME").toString() );
	}

}











