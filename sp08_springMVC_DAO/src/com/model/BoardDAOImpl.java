package com.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;
//@Component("board")
public class BoardDAOImpl implements MemberDAO {

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List memberById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean memberInsert(String id, String pwd, String email, int age) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
