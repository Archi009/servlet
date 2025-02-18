package com.yedam.vo;

import java.sql.Date;

public class BoardVO {
//	field
	private int boardNo ; //board_no
	private String title; //title
	private String content; //content
	private String writer; //writer
	private Date writeDate; // write_date
	private int viewCount; //view_count
	
	
	
//	constructor
	
	public BoardVO() {};
	
	
	public BoardVO(int boardNo, String title, String content, String writer, Date writeDate, int viewCount) {
		
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.viewCount = viewCount;
	}
	
	
	
//	getter setter
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
}
