package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class EmpDAO {
	
//	Connection 객체
	Connection getConnect() {

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 DB의 접속 정보.
		String user = "hr"; // 사용자 정보
		String password = "hr"; // 비밀번호
		Connection conn = null;
		try {
			// 첫번째 매개변수.(접속정보)
			Class.forName("oracle.jdbc.driver.OracleDriver");              //jdc에 oracledriver가 있는지 체크
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}//end of connection
	
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<Employee>();
		String sql = "select * from tbl_employees "
//					+ "where emp_name = nvl('"+emp.getEmpNm() +"',emp_name) "
				+ "where emp_name = nvl(?, emp_name)"        //createStatement보다 편하게 쿼리에서 타입을 생각하지하지 않고 바로 값을 입력 할 수있게
				+ "order by emp_no desc";
		try {
//			Statement stmt = getConnect().createStatement();
			PreparedStatement stmt = getConnect().prepareStatement(sql);
			stmt.setString(1, emp.getEmpNm());
			ResultSet rs = stmt.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				Employee empl = new Employee();
				empl.setEmpNo(rs.getInt("emp_no"));
				empl.setEmpNm(rs.getString("emp_name"));
				empl.setTelNo(rs.getString("tel_number"));
				empl.setHireDate(rs.getDate("hire_date"));
				empl.setSalary(rs.getInt("salary"));

				empList.add(empl);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}
	//단건 조회 empNo
	public Employee	selectEmp(int empNo) {
		Employee emp = new Employee();
		
		String query = "select * from tbl_employees "
					+ "where emp_no = ?";
		try {
			PreparedStatement stmt = getConnect().prepareStatement(query);
			stmt.setInt(1, empNo);
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(); //조회
			if(rs.next()) {//조회 결과가 한 건 있으면...
				emp.setEmpNo(rs.getInt("emp_no"));		
				emp.setEmpNm(rs.getString("emp_name"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setTelNo(rs.getString("tel_number"));
				return emp; //반환
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null; //조회결과 없을경우
		
	}
	
	
	//등록
	public boolean registerEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "insert into tbl_employees (emp_no,emp_name,tel_number)";
		query += " values (" + emp.getEmpNo() + ",' " 
		                    + emp.getEmpNm() + "', '" 
				            + emp.getTelNo()  
		                    + "')";
		try {
			Statement stmt = getConnect().createStatement();
			int r = stmt.executeUpdate(query);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}//end of registerEmp
	
	
}
