package edu.kosa.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeptDAOImpl implements DeptDAO {

	private JdbcTemplate jdbcTemplate;		//DML 명령 처리 클래스 -  insert, update, delete, select
	
	@Override
	public List listDept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDept(DeptDTO dto) {
		// TODO Auto-generated method stub

	}

}
