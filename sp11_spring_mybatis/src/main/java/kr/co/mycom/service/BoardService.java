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
	
	//���� ��ü ����
	public int getBoardCount();
	
	//��ȸ�� count
	public int updateHit(int num);
	
	//����
	public int updateBoard(BoardDTO dto);
	
	//����
	public int deleteBoard(BoardDTO dto);
	
	
	public void updateSort(BoardDTO dto);
	
	//�亯����
	public void insertReply(BoardDTO dto);
}
