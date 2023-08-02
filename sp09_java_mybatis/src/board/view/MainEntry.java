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
			System.out.print("1. select\n2. update\n3. insert\n4. delete\n0. 종료\n선택  >>\n");
			switch (sc.nextInt()) {
			
			case 1: // 출력
				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				break;

			case 2: // 수정
				vo = new BoardVO();
				System.out.println("수정할 번호");
				vo.setSeq(sc.nextInt());
				System.out.println("수정할 title, content, writer 입력");
				vo.setTitle(sc.next());
				vo.setContent(sc.next());
				vo.setWriter(sc.next());
				dao.update(vo);

				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				break;

			case 3: //추가
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
				System.out.println("seq를 입력해 주세요");
				vo.setSeq(sc.nextInt());
				dao.delete(vo);

				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				break;
				
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} // end switch
		}
	}
}
