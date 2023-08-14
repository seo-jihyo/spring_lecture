package com.example.security.model.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Setter;

/*
create table usr (
usrId varchar2(30) not null,
pwd varchar2(100) not null,
role number(2) default 0 not null,
regDate date not null
);
 */
@Setter
public class UserDTO extends User {
	
	private String userId;
	
	public UserDTO(String username, String password, 
			   boolean enabled,  boolean accountNonExpired, boolean accountNonLocked,
			   boolean credentialsNonExpired, Collection<? extends GrantedAuthority> authorities, String userid) {
	
	super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	this.userId = userid;
}


}
