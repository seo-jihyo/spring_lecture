package board.view;

import java.util.List;
import java.util.Scanner;

import board.controller.BoardDAO;
import board.model.BoardVO;

public class MainEntry {
	public static void main(String[] args) {
		
		while (true) {
			BoardDAO dao = new BoardDAO();
			BoardVO vo = null;
			List<BoardVO> list = null;

			Scanner sc = new Scanner(System.in);
			System.out.println("----------------");
			System.out.print("1. select\n2. update\n3. insert\n4. delete\n0. ����\n����  >>\n");
			switch (sc.nextInt()) {
			
			case 1: // ���
				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				break;

			case 2: // ����
				vo = new BoardVO();
				System.out.println("������ ��ȣ");
				vo.setSeq(sc.nextInt());
				System.out.println("������ title, content, writer �Է�");
				vo.setTitle(sc.next());
				vo.setContent(sc.next());
				vo.setWriter(sc.next());
				dao.update(vo);

				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				break;

			case 3: //�߰�
				vo = new BoardVO();
				System.out.println("content, title, writer: ");
				vo.setTitle(sc.next());
				vo.setContent(sc.next());
				vo.setWriter(sc.next());
				dao.insert(vo);

				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				break;
				
			case 4:
				vo = new BoardVO();
				System.out.println("seq�� �Է��� �ּ���");
				vo.setSeq(sc.nextInt());
				dao.delete(vo);

				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				break;
				
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			} // end switch
		}
	}
}
