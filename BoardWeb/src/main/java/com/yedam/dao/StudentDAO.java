package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends DAO {
	
	public boolean addStudent(Student student) {
		String sql = "insert into tbl_student (student_no, student_name, phone, address) "
					+"values(?,?,?,?)";
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setString(1, student.getStudNo());
			pstmt.setString(2, student.getStuNm());
			pstmt.setString(3, student.getStTelnO());
			pstmt.setString(4, student.getstuAddr());
			
			//쿼리 실행
			
			int r = pstmt.executeUpdate();
			if(r>0) {
				return true; //등록성공
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	//학생목록 반환.    참고)EmpDAO.search
	public List<Student> studentList(){
		List<Student> stuList = new ArrayList<Student>();
		
		
		
		String sql = "select * from tbl_student "
//					+ "where emp_name = nvl('"+emp.getEmpNm() +"',emp_name) "
//				+ "where emp_name = nvl(?, emp_name)"        //createStatement보다 편하게 쿼리에서 타입을 생각하지하지 않고 바로 값을 입력 할 수있게
				+ "order by student_no desc";
		try {

			pstmt = getConnect().prepareStatement(sql);
			

			rs = pstmt.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				Student stud = new Student();
				stud.setStudNo(rs.getString("student_no"));
				stud.setStuNm(rs.getString("student_name"));
				stud.setStTelnO(rs.getString("phone"));		
				stud.setstuAddr(rs.getString("address"));
				

				stuList.add(stud);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
	}//end of studentList
}
