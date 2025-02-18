package com.yedam.vo;

public class Student {
//	field
	private String studNo;
	private String stuNm;
	private String studTelnO;
	private String stuAddr;
	
	public Student() {};
	
	public Student(String studNo,String stuNm,String stTelnO,String stuAddr) {
		this.studNo = studNo;
		this.stuNm = stuNm;
		this.studTelnO = stTelnO;
		this.stuAddr = stuAddr;
	}
	
	
	//	getter setter
	public String getStudNo() {
		return studNo;
	}
	public void setStudNo(String studNo) {
		this.studNo = studNo;
	}
	public String getStuNm() {
		return stuNm;
	}
	public void setStuNm(String stuNm) {
		this.stuNm = stuNm;
	}
	public String getStTelnO() {
		return studTelnO;
	}
	public void setStTelnO(String stTelnO) {
		this.studTelnO = stTelnO;
	}
	public String getstuAddr() {
		return stuAddr;
	}
	public void setstuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}
	
	
	@Override
	public String toString() {
		return "Student [studNo=" + studNo + ", stuNm=" + stuNm + ", studTelnO=" + studTelnO + ", stuAddr=" + stuAddr
				+ "]";
	}
	
	
	
	
	
	
}
