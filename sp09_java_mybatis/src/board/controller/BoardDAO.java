package board.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVO;
import config.SqlSessionFactoryBean;

public class BoardDAO {

	private SqlSession sqlSession;
	
	public BoardDAO() {
		sqlSession = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	//boardVO type¿∏∑Œ return
	public List<BoardVO> selectAll(){
		return sqlSession.selectList("dao.selectAll");
	}
	
	public void update(BoardVO vo) {
		sqlSession.update("dao.update",vo);
		sqlSession.commit();
	}
	public void insert(BoardVO vo) {
		sqlSession.insert("dao.insert", vo);
		sqlSession.commit();
	}
	public void delete(BoardVO vo) {
		sqlSession.delete("dao.delete", vo);
		sqlSession.commit();
	}
	
	
//	public  void close() {
//		sqlSession.close();
//	}
}
