package com.kosa.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("user.insertUser", map);
	}

}
