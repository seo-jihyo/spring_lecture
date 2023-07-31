package edu.kosa.view;

import java.util.Scanner;

import edu.kosa.dao.OracleUserDAOImpl;
import edu.kosa.dao.UserDAO;
import edu.kosa.model.UserVO;

public class MainEntry2 {
	public static void main(String[] args) throws Exception {
		UserDAO dao = new OracleUserDAOImpl();
		Scanner sc = new Scanner(System.in);
		dao.menu();
		
		switch (sc.nextInt()) {
		case 1:	//Insert
			UserVO vo = new UserVO();
			System.out.println("user id: "); 	vo.setId(sc.next());
			System.out.println("user name: "); 	vo.setName(sc.next());
			System.out.println("user pass: "); 	vo.setPassword(sc.next());
			
			dao.insert(vo);
			System.out.println(vo.getId() + "추가 성공");
			System.out.println("----------------------");
			break;
		case 2:	//selectAll
			dao.menu();
			dao.selectAll();
			
			break;
		case 3: // selectById
			UserVO vo1 = new UserVO();
			
			System.out.println("id를 입력해 주세요");
			vo1.setId(sc.next());
			dao.selectById(vo1);
			break;

		default:
			break;
		}
	}
}
