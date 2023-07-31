package edu.kosa.view;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.kosa.dao_di.UserDAO;
import edu.kosa.model.UserVO;

public class MainEntry {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("edu/kosa/dao_di/ctx.xml");
		
		UserDAO  dao = ctx.getBean("dao", UserDAO.class);
		dao.menu();
		Scanner sc = new Scanner(System.in);
		
		switch (sc.nextInt()) {
			case 1:
					UserVO vo = new UserVO();
					System.out.print("user id= ");				vo.setId(sc.next());
					System.out.print("user name= ");			vo.setName(sc.next());
					System.out.print("user pass = ");			vo.setPassword(sc.next());
					
					dao.insert(vo);
					System.out.println(vo.getId() + "�߰� ����!!");
					System.out.println("----------------------------");
					break;
					
			case 2:  // selectAll
				dao.selectAll();
				break;
			case 3: // selectById
				UserVO vo1 = new UserVO();
				
				System.out.println("id�� �Է��� �ּ���");
				vo1.setId(sc.next());
				dao.selectById(vo1);
				break;
			case 4:
				UserVO vo2 = new UserVO();
				System.out.println("id�� �Է��� �ּ���");
				vo2.setId(sc.next());
				dao.delete(vo2);
			case 5:
				
			default:
				break;
		}
		
		/*
		UserDAO dao = new OracleUserDAOImpl();
		Scanner sc = new Scanner(System.in);

		dao.menu();
		switch (sc.nextInt()) {
			case 1:
					UserVO vo = new UserVO();
					System.out.print("user id= ");				vo.setId(sc.next());
					System.out.print("user name= ");			vo.setName(sc.next());
					System.out.print("user pass = ");			vo.setPassword(sc.next());
					
					dao.insert(vo);
					System.out.println(vo.getId() + "�߰� ����!!");
					System.out.println("----------------------------");
					break;
					
			case 2:  // selectAll
				dao.selectAll();
				break;
			case 3:
	
				break;
			default:
				break;
		}
		*/
	}
}
