package com.yedam.vo;

import lombok.Data;

@Data
public class StudentVO {
//	field
	private String studentNo;
	private String studentName;
	private String phone;
	private String address;
	
	
	
	@Override
	public String toString() {
		return "Student [studNo=" + studentNo + ", stuNm=" + studentName + ", studTelnO=" + phone + ", stuAddr=" + address
				+ "]";
	}
	
	
	
	
	
	
}
