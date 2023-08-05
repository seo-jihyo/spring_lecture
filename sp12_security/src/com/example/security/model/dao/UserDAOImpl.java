package com.example.security.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository //bean ����, component�� ����/ model��(data����) �ϴ� �͵��� Repository(�����) ����Ѵ�.
public class UserDAOImpl implements UserDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("user.insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String userid) { //mapper���� ��ȯ�� (resutType map���� ��), ���ڰ��� �Ѹ� �޾ƿ��Ƿ� userid
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.selectUser", userid);
	}

}
