package com.example.security.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository //bean 생성, component도 가능/ model단(data접근) 하는 것들은 Repository(저장소) 사용한다.
public class UserDAOImpl implements UserDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("user.insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String userid) { //mapper에서 반환값 (resutType map으로 줌), 인자값은 한명만 받아오므로 userid
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.selectUser", userid);
	}

}
