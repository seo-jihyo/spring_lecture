package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.co.mycom.model.BoardDAO;
import kr.co.mycom.model.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	//�Լ� �̸��� mapper�� id�� ���� ���ش�.
	@Override
	public void insertBoard(BoardDTO dto) {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		dao.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(HashMap map) {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.getBoardList(map);
	}

	@Override
	public int getBoardCount() {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.getBoardCount();
	}
	
	@Override
	public BoardDTO getBoard(int num) { //selectByNum(int num)
		BoardService dao = sqlSession.getMapper(BoardService.class);
		
		return dao.getBoard(num);
	}

	@Override
	public int updateHit(int num) { //��ȸ�� ����
		BoardService dao = sqlSession.getMapper(BoardService.class);
		
		return dao.updateHit(num);
	}

	@Override
	public int updateBoard(BoardDTO dto) { //����
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.updateBoard(dto);
	}

	@Override
	public int deleteBoard(BoardDTO dto) { //����
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.deleteBoard(dto);
	}

	@Override
	public void insertReply(BoardDTO dto) {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		dao.updateSort(dto);
		dao.insertReply(dto);
	}

	@Override
	public void updateSort(BoardDTO dto) {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		dao.updateSort(dto);
	}
	
}
