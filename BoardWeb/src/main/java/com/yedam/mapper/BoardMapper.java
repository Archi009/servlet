package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.common.SearchVO;

public interface BoardMapper {
	//interface 를 만들어 
	
	public int getTotalCount(SearchVO sr) ;
	public int updateCount(int baordNo);
	public BoardVO getBaord(int boardNo);
	public List<BoardVO>selectBoard(SearchVO sr);
	public int insertBoard(BoardVO board);
	public int deleteBoard(int boardNo);
	public int updateBoard(BoardVO board);
}
