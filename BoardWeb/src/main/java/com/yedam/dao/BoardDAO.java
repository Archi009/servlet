package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 추가, 수정, 삭제, 조회
 * Create, Read, Update, Delete
 */
public class BoardDAO extends DAO{
	//조회
	public List<BoardVO>selectBoard() throws SQLException{
		List<BoardVO>list = new ArrayList<BoardVO>();
		String sql = "selec#t * from tbl_board";
		
		pstmt = getConnect().prepareStatement(sql);
		System.out.println(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BoardVO br = new BoardVO();
			br.setBoardNo(rs.getInt("board_no"));
			br.setTitle(rs.getString("title"));
			br.setContent(rs.getString("content"));
			br.setWriter(rs.getString("writer"));
			br.setWriteDate(rs.getDate("write_date"));
			br.setViewCount(rs.getInt("view_count"));
			System.out.println(br.getTitle());
			list.add(br);
		}
		
		return list;
	}
	//추가
	public boolean insertBoard(BoardVO board) {
		
		return false;
	}
	
	//삭제
	public boolean deleteBoard(int boardNo) {
		
		return false;
	}
	
	//수정
	public boolean updateBoard(BoardVO board) {
		
		return false;
	}
}
