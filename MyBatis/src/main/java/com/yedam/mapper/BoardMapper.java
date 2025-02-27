package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//interface 를 만들어 
	List<BoardVO> selectAll();
	BoardVO selectBoardVO(int bno);
	int insertBoard(BoardVO vo);
	int deleteBoard(int bno);
}
