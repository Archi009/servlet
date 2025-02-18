package com.yedam;

import java.util.List;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

public class Test {
	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAO();
		List<Student> stu = sdao.studentList();
		
		for (Student st : stu) {
			System.out.println(st.toString());
		}
		
	}
}
