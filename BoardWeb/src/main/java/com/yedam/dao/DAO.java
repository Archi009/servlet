package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	
//	Connection 객체  Statement, PreparedStatement, ResultSet
	Connection conn = null;
	Statement	stmt;		 // 쿼리 실행, 결과 반환
	PreparedStatement pstmt;
	ResultSet rs;			 // 반환된 결과를 담아두는 변수
	
	Connection getConnect() {

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 DB의 접속 정보.
		String user = "hr"; // 사용자 정보
		String password = "hr"; // 비밀번호
		try {
			// 첫번째 매개변수.(접속정보)
			Class.forName("oracle.jdbc.driver.OracleDriver");              //jdc에 oracledriver가 있는지 체크
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}//end of connection
}
