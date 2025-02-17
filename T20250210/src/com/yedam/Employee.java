package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
//	field
	private String empNo;
	private String empNm;
	private String telNo;
	private Date hireDate;
	private int salary;

//	constructor
	public Employee() {

	}

	public Employee(String empNo, String empNm, String telNo, String hireDate, int salary) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.empNo = empNo;
		this.empNm = empNm;
		this.telNo = telNo;
		try {
			this.hireDate =  sdf.parse(hireDate);
			
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

		return empNo + "  " + empNm + "  " + telNo + "  " +salary ;
	}
	public String empInfoHire() {
//		사번   이름   연락처   급여
//		-------------------
//		1001 홍길동 234-1234 250
		SimpleDateFormat sdf = new SimpleDateFormat();
		return empNo + "  " + empNm + "  " + sdf.format(hireDate)  ;
	}

	// getter setter
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
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

	public void setHireDate(String hdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.hireDate =  sdf.parse(hdate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
