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
//로그인 처리 클래스
public class UserAuthenticationService implements UserDetailsService {

//	@Autowired 걸면 생성자 작성할 필요없음
	private SqlSessionTemplate sqlSession;	//db연결
	
	public UserAuthenticationService() { 	} //default 생성자
	
	public UserAuthenticationService(			//인자값 있는 생성자
			SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userid) 
			throws UsernameNotFoundException {
		//사용자 아이디 확인, mapper의 이름과 맞춘다.
		Map<String,Object> user=sqlSession.selectOne("user.selectUser", userid);	
		//아이디가 없으면 예외 발생
		if(user==null) throw new UsernameNotFoundException(userid);
		
		//사용권한 목록
		List<GrantedAuthority> authority= new ArrayList<>();
		authority.add(new SimpleGrantedAuthority(user.get("AUTHORITY").toString())); //필드명은 대문자로
		return new UserDTO(user.get("USERNAME").toString(),
								user.get("PASSWORD").toString(),
								true,
								true,true,true,authority,
								user.get("USERNAME").toString() );
	}

}











