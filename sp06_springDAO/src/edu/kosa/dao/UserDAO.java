package edu.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kosa.model.UserVO;

public abstract class UserDAO { // �߻�Ŭ����

	// DB ���� ���� �޼ҵ�
	public abstract Connection getConnection() throws Exception; // �߻�޼���

	// 3. ��� (DML ��ɾ�)

	// insert
	public void insert(UserVO vo) throws Exception {
		Connection conn = getConnection();
		String sql = "insert into users(id, name, password) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		int result = pstmt.executeUpdate();
		System.out.println(result + "�� �Է� ����");

		pstmt.close();
		conn.close();
	}


	// selectAll
	public void selectAll() throws Exception {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from users");

			System.out.println("\n\n id \t name \t pwd");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				System.out.println(id + "\t" + name + "\t" + pwd);
			} // while end
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// selectById
	public void selectById(UserVO vo) throws Exception {
		Connection conn = getConnection();
		String sql = "select id, name, password from users where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		
		pstmt.setString(1, vo.getId());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String pwd = rs.getString("password");
			System.out.println("id: " + id + ", name: " + name + ", pwd: " + pwd);
		}
		
		pstmt.close();
		conn.close();
	}

	// update

	// delete

	// menu
	public void menu() {
		System.out.println("�����ϼ���: \n1.Insert ");
		System.out.println("2.SelectAll \n3.SelectById \n4.Update \n5.Delete ");
	}

}
