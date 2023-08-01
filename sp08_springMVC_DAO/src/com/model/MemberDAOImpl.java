package com.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//(@Component("dto") //bean ���� - memberDAO{
@Component
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;		//dml ��� ó�� Ŭ����
	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {	//Ư�� id�� �˻�
		String sql = "select * from usermember where id = ?";

		try {
			return this.jdbcTemplate.queryForObject(sql, 
					new BeanPropertyRowMapper<MemberVO>(MemberVO.class), id);
			
//			��� 2
//			return this.jdbcTemplate.queryForObject(sql, new Object[] {id},MemberVO.class);
		} catch (Exception e) {
//			return new EmptyResultDataAccessException(0);	//���� �߻��� null ����
//			System.out.println(e.getMessage());				//�߻��� �޽��� ���
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List memberById(String id) throws SQLException { 	//Ư�� id�� �˻�
		String sql = "select * from usermember where id = ?";
		return this.jdbcTemplate.queryForList(sql, id);
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException {
		String sql = "SELECT * FROM USERMEMBER WHERE ID = ? and pwd = ?";
		boolean flag = false;
		Object[] params = {id, pwd};
		
		if (this.jdbcTemplate.queryForList(sql, params).size() > 0) flag = true;
		
		return flag;
	}

	@Override
	public boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException {
		
		String sql = "INSERT INTO USERMEMBER VALUES(?,?,?,?,?)";
		boolean flag = false;
		
		Object[] params = {id, name, pwd, email, age};
		
		if(this.jdbcTemplate.update(sql, params) > 0 ) flag = true;  //0���� Ŭ ��� �����Ͱ� ����, insert�� �ȴٸ� true 
		
		return flag;
		
	}

}
