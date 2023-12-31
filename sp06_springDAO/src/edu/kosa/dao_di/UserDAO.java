package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import edu.kosa.model.UserVO;

public class UserDAO {

	@Autowired
	private ConnectionMaker connectionMaker; // has-a

//	public UserDAO(ConnectionMaker connectionMaker) { // DI - constructor
//		this.connectionMaker = connectionMaker;
//	}
	
	public UserDAO() { }

//	public void setConnectionMaker(ConnectionMaker connectionMaker) { // DI - setter method
//		this.connectionMaker = connectionMaker;
//	}

	// 3. DML명령어
	// insert
	public void insert(UserVO vo) {
		Connection conn = null;
		PreparedStatement  pstmt = null;
		
		try {
			conn = connectionMaker.makeConnection();   // db connect
			
			String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			int result = pstmt.executeUpdate();
			System.out.println(result + " 개 입력 성공!!! connectionMaker");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {			pstmt.close();			conn.close();		} catch (Exception e) { e.printStackTrace();  }
		}  //end try
		
	} // end insert()
	
	// selectAll
	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connectionMaker.makeConnection(); 
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM USERS");
			
			System.out.println("\nID \tName \tPWD");
			System.out.println("=====================");
			while( rs.next() ) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				System.out.println(id+"\t" + name +"\t"+ pwd);
			} // while end
			System.out.println("=====================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {	stmt.close();      conn.close();		} catch (Exception e) {		e.printStackTrace(); 	}
		}  // try end
		
	} // end selectAll()
	
	// selectById
	public void selectById(UserVO vo) throws Exception {
		Connection conn = connectionMaker.makeConnection();
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
	// delete 
		public void delete(UserVO vo) throws Exception {
			Connection conn = connectionMaker.makeConnection();
			String sql = "delete from users where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "개 삭제 완료");
			
			
		}
	// update
		public void update(UserVO vo) throws Exception {
		    Connection conn = connectionMaker.makeConnection();
		    String sql = "UPDATE users SET name=?, password=? WHERE id=?";
		    PreparedStatement pstmt = conn.prepareStatement(sql);

		    pstmt.setString(1, vo.getName());
		    pstmt.setString(2, vo.getPassword());
		    pstmt.setString(3, vo.getId());

		    int result = pstmt.executeUpdate();

		    System.out.println(result + "개 업데이트 완료");

		    pstmt.close();
		    conn.close();
		}
	// menu
	public void menu() {
		System.out.println("1.Insert \n2.SelectAll \n3.SelectById \n4.Update \n5.Delete \n0.exit ");
		System.out.print("선택하세요 >>  ");
	}
}
