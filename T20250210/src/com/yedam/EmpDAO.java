package com.yedam;

import java.util.ArrayList;

import java.util.List;

public class EmpDAO {

	List<Employee> storage = new ArrayList<Employee>(); //담을 Stroage

	public EmpDAO() {
//		초기값
		storage.add(new Employee("23-11", "홍길동", "943-1234", "2023-10-11", 500));
		storage.add(new Employee("23-12", "김길동", "945-1255", "2022-10-11", 250));
		storage.add(new Employee("23-13", "박길동", "944-1744", "2021-10-11", 400));
		storage.add(new Employee("23-14", "이길동", "946-1154", "2020-10-11", 300));

	}
	
//	등록
	public boolean registerEmp(Employee emp) {
		return storage.add(emp);
	}
	
//	목록
	public List<Employee> searchList(Employee emp) {
		List<Employee> result = new ArrayList<Employee>();
		
		for (int i = 0; i < storage.size(); i++) {
			if (emp.getHireDate()!=null) { //매개변수에 hireDate존재유무 확인
				if(storage.get(i).getHireDate().compareTo(emp.getHireDate())>=0) {
//					compareTo가 날짜를 비교해서 크면 양수 작으면 음수 같으면 0을 반환
					result.add(storage.get(i));
				}
			}else {
//				일반조회
			result.add(storage.get(i));
			}
		}
		return result;
	}
	
//	수정
	public boolean modSal(Employee emp) {
		for(int i = 0; i <storage.size();i++) {
//			매개변수의 사번과 비교
			if(storage.get(i).getEmpNo().equals(emp.getEmpNo())) {
			 storage.get(i).setSalary(emp.getSalary());
			 return true;
			}
		}
		return false;
	}
	
//	삭제
	public boolean delList(Employee emp) {
		for(int i = 0; i <storage.size();i++) {
//			매개변수의 사번과 비교
			if(storage.get(i).getEmpNo().equals(emp.getEmpNo())) {
				 storage.remove(i);
				 return true;
				}
		}
		
		return false;
	}
	
}
