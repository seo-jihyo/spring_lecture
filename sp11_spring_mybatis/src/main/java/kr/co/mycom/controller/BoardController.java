package kr.co.mycom.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mycom.model.BoardDTO;
import kr.co.mycom.service.BoardService;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/writeform.htm")
	public String writeform() {
		return "writeform";
	}
	
	@RequestMapping("/write.htm")
	public String write(BoardDTO dto) {
		boardService.insertBoard(dto);
		return "list";
	}
	
	@RequestMapping("/list.htm")
	public String list(HttpServletRequest request) {
		
		int pg = 1;
		String strPg = request.getParameter("pg");
		
		if (strPg != null) {
			pg = Integer.parseInt(strPg);
		}
		int rowSize = 5;	//한번에 보여지는
		int start = (pg * rowSize) - (rowSize - 1);
		int end = pg*rowSize;
		
		int total = boardService.getBoardCount();	//총 게시물수
		System.out.println(start + ", " + end + ", " + total);
		
		int allPage = (int)Math.ceil(total/(double)rowSize);	//페이지수
		System.out.println("allPage: " + allPage);
		
		int block =10;	//한페이지에 보여줄 범위 <<[1][2][3]...[8][9][10]>>
		int formPage = ( (pg - 1) / block*block ) + 1; //보여줄 페이지의 시작
		int toPage = ( (pg -1) / block*block ) + block;	//보여줄 페이지의 끝
		
		if (toPage > allPage) {
			toPage  = allPage;
		}
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardDTO> list = boardService.getBoardList(map);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("allPage", allPage);
		request.setAttribute("formPage", formPage);
		request.setAttribute("toPage", toPage);
		request.setAttribute("block", block);

		return "list"; //list.jsp 로 
	}
	
	@RequestMapping("/read.htm")
	public String read(int num, int pg, Model model) {

		boardService.updateHit(num);	//읽는 순간 조회수 증가
		BoardDTO dto = boardService.getBoard(num);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pg", pg);
		
		return "read"; //read.jsp
	}
	
	//수정버튼 클릭시 
	@RequestMapping("/updateform.htm")
	public String updateform(int num, int pg, Model model) {
		BoardDTO dto = boardService.getBoard(num);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pg", pg);
		
		return "updateform";
	}

	@RequestMapping("/update.htm")
	public String update(BoardDTO dto, int pg) {
		int result = boardService.updateBoard(dto);	//실패 : 0 성공: 1
		String res = "redirect:/list.htm?pg="+pg; 	//리다이렉트 url을 재지정, 주소가 바뀜
		
		if (result == 0)  res = "fail";
			return res;
	}
	@RequestMapping("/deleteform.htm")
	public String deleteform(int num, int pg, Model model) {
		BoardDTO dto = boardService.getBoard(num);
		
		model.addAttribute("dto",dto);
		model.addAttribute("pg",pg);
		
		return "deleteform";
	}
	@RequestMapping("/delete.htm")
	public String delete (BoardDTO dto, int pg) {
		int result = boardService.deleteBoard(dto);
		String res = "redirect:/list.htm?pg="+pg;
		
		if(result == 0) res = "fail";
		return res;
	}

	@RequestMapping("/replyform.htm")
	public String replyform(int num, Model model) {
		BoardDTO dto = boardService.getBoard(num);
		model.addAttribute("dto",dto);
		
		return "replyform";
	}
	
	@RequestMapping("/reply.htm")
	public String reply(BoardDTO dto, int pg) {
		dto.setSort(dto.getSort() + 1);
		dto.setTab(dto.getTab() + 1);
		
		boardService.insertReply(dto);
		return "redirect:/list.htm?pg="+pg;
	}
}
