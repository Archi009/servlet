package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *  사원 번호(1001,1002...)
 *  사원 이름("홍길동", "김민수")
 *  전화번호 (654-1123, 643-1111)
 *  입사일자 (2020-12-04)
 *  급여    (300, 350)
 *  
 */

public class Employee {

//	field
	private int empNo;
	private String empNm;
	private String telNo;
	private Date hireDate;
	private int salary;

//	constructor
	public Employee() {
	}

	public Employee(int empNo, String empNm, String telNo) {
		this.empNo = empNo;
		this.empNm = empNm;
		this.telNo = telNo;
		this.hireDate = new Date(); // 입사일자를 따로 입력하지 않으면 오늘 날짜로
		this.salary = 250;
	}

	public Employee(int empNo, String empNm, String telNo, String hireDate, int salary) {
		this(empNo, empNm, telNo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.hireDate = sdf.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();

		}
		this.salary = salary;
	}

//	사번, 이름, 연락처, 급여.
	public String empInfo() {
//		사번   이름   연락처   급여
//		-------------------
//		1001 홍길동 234-1234 250

		return empNo + "  " + empNm + "  " + telNo + "  " + salary;
	}

//	getter , setter

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
