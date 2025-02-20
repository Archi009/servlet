package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

//	Connection 객체  Statement, PreparedStatement, ResultSet

	Connection conn = null;
	Statement stmt; // 쿼리 실행, 결과 반환
	PreparedStatement pstmt;
	ResultSet rs; // 반환된 결과를 담아두는 변수

//	세션 해제
	void disConnect() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 오라클 접속 세션 연결
	Connection getConnect() {

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 DB의 접속 정보.
		String user = "hr"; // 사용자 정보
		String password = "hr"; // 비밀번호
		try {
			// 첫번째 매개변수.(접속정보)
			Class.forName("oracle.jdbc.driver.OracleDriver"); // jdc에 oracledriver가 있는지 체크
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}// end of connection
}
