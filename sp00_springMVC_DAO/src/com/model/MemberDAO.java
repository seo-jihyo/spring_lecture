package com.model;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {

	//ȸ�� �� ����
	MemberVO selectMemberById(String id) throws SQLException;
	List memberById(String id) throws SQLException;
	
	boolean memberCheck(String id, String pwd) throws SQLException;
	
	boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException;
}
