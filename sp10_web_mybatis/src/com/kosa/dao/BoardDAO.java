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
			BoardVO vo = sqlSession.selectOne("dao.detailList", seq); //vo �����ؼ� selectone(mybatis�Լ�)�� ������
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
	
	//��ü �˻� ��ȸ - 1
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

	//��ü �˻� ��ȸ - 2
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
