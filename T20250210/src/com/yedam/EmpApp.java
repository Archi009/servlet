package com.yedam;

import java.util.List;
import java.util.Scanner;

public class EmpApp {
	static Scanner scn = new Scanner(System.in);
	static int eNum = 0;
	static EmpDAO dao = new EmpDAO();
	static String eNo = "";
	static String eName = "";
	static String phNo = "";
	static String hdate = "";
	static int sal = 0;

	public static void main(String[] args) {
//		while -run
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.println(" 선택 >>");
			int menu = 0;
			//menu 숫자 입력
			try {
				menu =Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
				break;
			}
			
			
			switch (menu) {
			case 1:
//				등록
				register();
				break;
			case 2:
//				전체조회
				searchList(2);
				break;

			case 3:
//				수정			
				modSal();
				break;

			case 4:
//				삭제
				break;

			case 5:
				searchList(5);
				break;
			case 6:
				System.out.println("end of prog");
				run = false;
				break;

			default:
				break;
			}// end of switch
		} // end of while
	}// end of main

	static void register() {
//      등록
		System.out.println("사번입력 >> ");
		eNo = scn.nextLine();
		System.out.println("이름입력 >> ");
		eName = scn.nextLine();
		System.out.println("전화번호입력 >> ");
		phNo = scn.nextLine();
		System.out.println("입사일입력 >> ");
		hdate = scn.nextLine();
		System.out.println("급여입력 >> ");
		sal = Integer.parseInt(scn.nextLine());

		if (dao.registerEmp(new Employee(eNo, eName, phNo, hdate, sal))) {
			System.out.println("등록 완료");
			return;
		}
		System.out.println("등록 실패");

	}//end of register

	static void searchList(int num) {
//		조회
		Employee emp = new Employee();

		if (num == 5) { //입사일 조회일때 출력문
			System.out.println("입사일입력 >> ");
			hdate = scn.nextLine();
			emp.setHireDate(hdate);// 입사일 조회일때 입사일 설정한 값을 담아줌
			System.out.println(" 사번   이름    입사일자");
			System.out.println("---------------------------");
		}else { //일반 조회일때 출력문 (수정시 수정 확인위해 급여추가)
		
		System.out.println(" 사번   이름    전화번호     급여");
		System.out.println("---------------------------");
		}
		List<Employee> result = dao.searchList(emp);
		for (Employee empl : result) {
			if (empl != null) {
				if (num == 5) {//입사일자 입력 조회
					System.out.println(empl.empInfoHire());
				} else {//일반 조회
					System.out.println(empl.empInfo());
				}
			}
		}
	}//end of searchList
	
	static void modSal() {
		System.out.println("사번입력 >> ");
		eNo = scn.nextLine();
		System.out.println("수정 급여입력 >> ");
		sal =Integer.parseInt(scn.nextLine()) ;
		Employee emp = new Employee();
		emp.setEmpNo(eNo);
		emp.setSalary(sal);
		if(dao.modSal(emp)) { //수정시 true반환
			System.out.println("수정완료");
			return;
		}
		System.out.println("입력하신 사번이 없습니다. 확인해주세요.");
		
	}//end of modSal
	static void delList() {
		Employee emp = new Employee();
		System.out.println("사번입력 >> ");
		eNo = scn.nextLine();
		emp.setEmpNo(eNo);
		if(dao.delList(emp)) { //삭제시 true반환
			System.out.println("삭제완료");
			return;
		}
		System.out.println("입력하신 사번이 없습니다. 확인해주세요.");
	}
}
