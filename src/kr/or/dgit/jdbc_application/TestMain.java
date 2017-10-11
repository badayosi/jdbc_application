package kr.or.dgit.jdbc_application;

import java.sql.Connection;

import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.jdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance();
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		jdbcUtil.close(connection);
	}
}
