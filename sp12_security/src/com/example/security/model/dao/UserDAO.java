package com.example.security.model.dao;

import java.util.Map;

public interface UserDAO {

	//ȸ������ ó��
	public int insertUser(Map<String, String> map);
	
	//�α��� ó��
	public Map<String, Object> selectUser(String userid);
	
	//
}
