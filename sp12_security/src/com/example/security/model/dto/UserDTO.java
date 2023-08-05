package com.example.security.model.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDTO extends User { //model

	private String userid;
	
	public UserDTO(String username, String password, 
				   boolean enabled,  boolean accountNonExpired, boolean accountNonLocked,
				   boolean credentialsNonExpired, Collection<? extends GrantedAuthority> authorities, String userid) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + "]";
	}
}