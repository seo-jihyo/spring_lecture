package com.kosa.service;

import java.util.Map;

public interface UserService {
	public int insertUser(Map<String, String> map);
	public int updateUsr(Map<String, String> map);
}
