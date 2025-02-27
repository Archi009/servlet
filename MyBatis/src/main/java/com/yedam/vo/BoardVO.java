package com.yedam.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
//	field
	private int boardNo ; //board_no
	private String title; //title
	private String content; //content
	private String writer; //writer
	private String img; // images
	private Date writeDate; // write_date
	private int viewCount; //view_count
	
	
	
//	constructor
	
	
	
	
	

	
	
}
