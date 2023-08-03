package com.kosa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.kosa.config.SqlSessionFactoryService;
import com.kosa.model.BoardVO;


@Component
public class BoardDAO {
	private SqlSessionFactoryService sqlSessionFactory;
	private SqlSession sqlSession = null;	//DML 처리 함수를 갖고 있다.

	//select all
	public List<BoardVO> selectAll(){
		try {
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession(); //app과 db의 연결 통로
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
	
	//insert
	public int insert(BoardVO vo) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession();
			sqlSession.insert("dao.insert", vo);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}



	//detail list
	public BoardVO detailList(int seq) { //return vo
		try {
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession();
			BoardVO vo = sqlSession.selectOne("dao.detailList", seq); //vo 생성해서 selectone(mybatis함수)로 가져옴
			return vo;
		} catch (Exception e) {
			return null;
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	// delete
	public int delete(int seq) {
	   try {
	      sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession();
	      int rowcount = sqlSession.delete("dao.delete", seq);
	      sqlSession.commit();
	      return rowcount;
	   } catch (Exception e) {
	      return 0;
	   } finally {
	      if (sqlSession != null) {
	         sqlSession.close();
	      }
	   }
	}
	//update
	public int update(BoardVO vo) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession();
			int rowcount = sqlSession.update("dao.update", vo); 
			sqlSession.commit();
			return rowcount;
			
		} catch (Exception e) {
			return 0;
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//전체 검색 조회 - 1
	public List<BoardVO> selectSearchList(Map<String, String> map) {
		try {
			/*
			 * for(Map.entry(String, String)m : map.entrySet()) {
			 * System.out.println(m.getKey() + "/" + m.getValue() + "-");
			 */
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession();
			return sqlSession.selectList("dao.selectSearch", map);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	//전체 검색 조회 - 2
	public List<BoardVO> selectSearchList2(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession();
			return sqlSession.selectList("dao.selectSearch2", map);
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
