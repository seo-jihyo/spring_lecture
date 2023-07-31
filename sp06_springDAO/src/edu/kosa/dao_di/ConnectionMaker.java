package edu.kosa.dao_di;

import java.sql.Connection;

//확장 가능, 관계를 느슨하게 처리
public interface ConnectionMaker {

	Connection makeConnection() throws Exception;
}
