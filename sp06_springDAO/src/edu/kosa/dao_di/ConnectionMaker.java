package edu.kosa.dao_di;

import java.sql.Connection;

//Ȯ�� ����, ���踦 �����ϰ� ó��
public interface ConnectionMaker {

	Connection makeConnection() throws Exception;
}
