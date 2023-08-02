package com.kosa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.kosa.config.SqlSessionFactoryService;
import com.kosa.model.BoardVO;


@Component
public class BoardDAO {
	private SqlSessionFactoryService sqlSessionFactory;
	private SqlSession sqlSession = null;	//DML ó�� �Լ��� ���� �ִ�.
	
	//select all
	public List<BoardVO> selectAll(){
		try {
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession(); //app�� db�� ���� ���
			return sqlSession.selectList("dao.selectAll");
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	public void insert(BoardVO vo) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession();
			sqlSession.insert("dao.insert", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
