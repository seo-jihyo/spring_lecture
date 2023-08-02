package com.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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

		String sql = "select * from usermember where id = ? and pwd = ?";
		boolean flag = false;
		Object[] params = {id, pwd};
		
		if (this.jdbcTemplate.queryForList(sql, params).size() > 0) flag = true;
		
		return flag;
	}

	@Override
	public boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException {
		
		String sql = "insert into usermember values(?,?,?,?,?)";
		boolean flag = false;
		
		Object[] params = {id, name, pwd, email, age};
		
		if(this.jdbcTemplate.update(sql, params) > 0) flag = true;
		
		return flag;
	}

}
