package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mycom.model.BoardDTO;

public interface BoardService {
	
	//insert
	public void insertBoard(BoardDTO dto);
	
	//select all
	public List<BoardDTO> getBoardList(HashMap map);
	
	//selectByNum
	public BoardDTO getBoard(int num);	
	
	//글의 전체 개수
	public int getBoardCount();
	
	//조회수 count
	public int updateHit(int num);
	
	//수정
	public int updateBoard(BoardDTO dto);
	
	//삭제
	public int deleteBoard(BoardDTO dto);
	
	
	public void updateSort(BoardDTO dto);
	
	//답변저장
	public void insertReply(BoardDTO dto);
}
