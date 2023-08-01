package com.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.SQLWarningException;

public interface MemberDAO {
	
	//ȸ�� �� ��ȸ
	MemberVO selectMemberById(String id)throws SQLException;
	List memberById(String id) throws SQLException;
	
	//ȸ�� ������ �Ǵ��ϴ� ��ȸ �޼ҵ�
	boolean memberCheck(String id, String pwd) throws SQLException;
	
	boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException;
}
