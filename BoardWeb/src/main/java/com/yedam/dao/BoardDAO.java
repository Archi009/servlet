package com.yedam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 추가, 수정, 삭제, 조회
 * Create, Read, Update, Delete
 */
public class BoardDAO extends DAO{
	
	public int getTotalCount() {
		String sql ="select count(1) from tbl_board";
		try {
			pstmt = getConnect().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			 return	rs.getInt(1); // count(1)값
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return 0; //조회정보 없음.
	}
	
//	조회수 증가
	public void updateCount(int baordNo) {
		String sql = "update tbl_board set view_count = view_count +1 where board_no = ?";
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setInt(1, baordNo);
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.println("조회!");
			}else {
				System.out.println("조회 실패!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //정상 실행이건 예외 발생이건 진행한다.
			disConnect();
		}
		
		
	}
	
//	상세조회
	public BoardVO getBaord(int boardNo) {
		String string= "select board_no"
		+ " ,title"
		+ " ,content"
		+ " ,writer"
		+ " ,write_date"
		+ " ,view_count"
		+ " from tbl_board"
		+ " where board_no = ?";
		
		try {
			pstmt = getConnect().prepareStatement(string);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setWriter(rs.getString("writer"));
				board.setViewCount(rs.getInt("view_count"));
				//결과 반환
				return board;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
				
		
		return null; //조회 결과 없음
		
	}
	
	
	//조회
	public List<BoardVO>selectBoard(int page) throws SQLException{
		List<BoardVO>list = new ArrayList<BoardVO>();
		String sql = "select * from "
			+"	(select rownum rn, a.* "
			+"			from (select * from tbl_board order by board_no desc) a) b "
			+"			where b.rn>= (? - 1)*5 +1 and b.rn<= (? *5)";
		
		
		pstmt = getConnect().prepareStatement(sql);
		pstmt.setInt(1, page);
		pstmt.setInt(2, page);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BoardVO br = new BoardVO();
			br.setBoardNo(rs.getInt("board_no"));
			br.setTitle(rs.getString("title"));
			br.setContent(rs.getString("content"));
			br.setWriter(rs.getString("writer"));
			br.setWriteDate(rs.getDate("write_date"));
			br.setViewCount(rs.getInt("view_count"));
			
			
			list.add(br);
		}
		
		disConnect();
		return list;
	}
	//추가
	public boolean insertBoard(BoardVO board) {
		String query =  "insert into tbl_board ( board_no, title, content, writer)" 
				+" values(board_seq.nextval,?,?,?)";
		
		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			int result =  pstmt.executeUpdate();
			
			if (result>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		
		return false;
	}
	
	//삭제
	public boolean deleteBoard(int boardNo) {
		String query =  "delete from tbl_board where board_no = ?";
		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return false;
	}
	
	//수정
	public boolean updateBoard(BoardVO board) {
		String sql = "update tbl_board set title = ? , content = ? where board_no = ?";
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNo());
			
			int result = pstmt.executeUpdate();
			if (result> 0) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		
		return false;
	}

	
}
