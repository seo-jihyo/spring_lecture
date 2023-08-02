package com.kosa.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryService {


	private static SqlSessionFactory  sqlSessionFactory  = null;
	
	static {
		try {
			if( sqlSessionFactory == null ) {
				Reader reader = Resources.getResourceAsReader("./sqlMapConfig.xml");   // mybatis ¼³Á¤file path
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionInstance() {
		return  sqlSessionFactory;
	}

}
