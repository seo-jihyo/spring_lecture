package com.javassem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyServiceImpl replyService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	//글쓰기 페이지로 이동 
	@GetMapping("board/insertBoard.do")
	public String insertform(Model model) {

		return "board/insertBoard";
	}

	//글작성 서비스 
	@PostMapping("/board/saveBoard.do")
	public String insertBoard(BoardVO vo) {
		/* System.out.println(vo); */
		boardService.insertBoard(vo);
		return "redirect:/board/getBoardList.do";
	}

	//글 작성페이지 -> 글 목록 페이지로 이동 
	@GetMapping("/board/getBoardList.do")
	public String boardlist(Model model, String searchCondition, String searchKeyword) {
		Map<String, String> map = new HashMap<>();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);

		/*List<BoardVO> boardList= boardService.getBoardList((HashMap) map);*/
		/* System.out.println(boardList); */
		model.addAttribute("boardList", boardService.getBoardList((HashMap) map));

		return "/board/getBoardList";
	}

	//상세 보기 페이지로 이동 + 글 상세보기 기능
	@GetMapping("/board/getBoard.do")
	public String getBoard(Model model, BoardVO vo) {
		//seq는 컨트롤러 에서 받아온게 아니라 보내줄때 같이 보내줬음 !! 
		boardService.updateCnt(vo.getSeq()); //조회수 업데이트 
		model.addAttribute("board", boardService.getBoard(vo));


		return "/board/getBoard";
	}

	//글 수정 버튼 클릭시 
	@PostMapping("/board/updateBoard.do")
	public String updateBoard(Model model, BoardVO vo) {
		boardService.updateBoard(vo);

		HashMap map = new HashMap();
		map.put("vo", vo);

		List<BoardVO> boardList = boardService.getBoardList(map);
		model.addAttribute("boardList", boardList);

		return "/board/getBoardList";
	}

	@PostMapping("/replies/new")
	@ResponseBody
	public String repliesinsert(ReplyVO vo) {
		replyService.insertReply(vo);
		return null;
	}

	@PostMapping("/replies/{bno}")
	@ResponseBody
	public List<ReplyVO> selectAllReplies(@PathVariable int bno) {
		System.out.println(bno);
		return replyService.selectAllReply(bno);
	}

	@DeleteMapping(value="/replies/{rno}", produces = "text/plain; charset = UTF-8")
	@ResponseBody
	public String replydelete(@PathVariable String rno){
		if(replyService.deleteReply(rno)>0){
			return "삭제 완료 했습니다.";
		}else {
			return "삭제 실패";
		}
	}

	@PutMapping("/replies/{rno}")
	@ResponseBody
	public ReplyVO replyUpdate(@PathVariable String rno, @RequestBody ReplyVO vo ){
		int result = replyService.updateReply(vo);
		System.out.println(result);
		return null;
	}

}
