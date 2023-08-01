package edu.kosa.view;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.kosa.dao_di.UserDAO;
import edu.kosa.model.UserVO;

public class MainEntry {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("edu/kosa/dao_di/ctx.xml");

		while(true) {
		UserDAO dao = ctx.getBean("dao", UserDAO.class);
		dao.menu();
		Scanner sc = new Scanner(System.in);
		switch (sc.nextInt()) {
		case 1:
			UserVO vo = new UserVO();
			System.out.print("user id= ");
			vo.setId(sc.next());
			System.out.print("user name= ");
			vo.setName(sc.next());
			System.out.print("user pass = ");
			vo.setPassword(sc.next());

			dao.insert(vo);
			System.out.println(vo.getId() + "추가 성공!!");
			System.out.println("----------------------------");
			break;

		case 2: // selectAll
			dao.selectAll();
			break;
		case 3: // selectById
			UserVO vo1 = new UserVO();

			System.out.println("id를 입력해 주세요");
			vo1.setId(sc.next());
			dao.selectById(vo1);
			break;
		case 4: // update
			UserVO vo2 = new UserVO();
			System.out.println("------------");
			dao.selectAll();
			System.out.println("id를 입력해 주세요");
			vo2.setId(sc.next());
			System.out.println("변경할 이름을 입력해 주세요");
			vo2.setName(sc.next());
			System.out.println("변경할 비밀번호를 입력해 주세요");
			vo2.setPassword(sc.next());
			dao.update(vo2);
			break;

		case 5: // delete
			UserVO vo3 = new UserVO();
			System.out.println("id를 입력해 주세요");
			vo3.setId(sc.next());
			dao.delete(vo3);
			break;
		case 0:
			System.out.println("츠로그램 종료");
			System.exit(0);
		default:
			System.out.println("다시 입력하세요.");
		}
		}
	}
}
