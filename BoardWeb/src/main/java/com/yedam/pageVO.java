package com.yedam;

import lombok.Data;

@Data
public class pageVO {
//	67건 1 ~ 14페이지
//	현재 페이지 : 2페이지. 1~10페이지.
//	현재 페이지 : 12페이지. 11~14페이지.
	
	private int startPage; //현재 페이지 기준 첫 페이지
	private int endPage; //현재 페이지 기준 마지막 페이지
	private int currentPage; //현재 페이지 
	private boolean prev;
	private boolean next;
	
	public pageVO(int page, int totalCnt){
		this.currentPage = page;
		endPage =(int) Math.ceil(currentPage/10.0) *10; 
		this.startPage = endPage - 9;// 계산상의 start, end
		
		int realEnd = (int) Math.ceil(totalCnt / 5.0); //실제 마지막 페이지
		System.out.println("real"+realEnd);
		this.endPage = endPage > realEnd ? realEnd : endPage;
		
		prev = startPage == 1 ? false : true;
		next = endPage == realEnd ? false : true;
	}
	
	
}
