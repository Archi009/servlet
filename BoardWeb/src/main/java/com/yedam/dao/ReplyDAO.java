package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.ReplyVO;

//댓글 목록, 등록 , 삭제 , 상세조회.
public class ReplyDAO extends DAO {
	//목록.
	public List<ReplyVO> replyList (int boardNo){
		List<ReplyVO> rp=new ArrayList<>();
		String sql = "select reply_no, reply, replyer, reply_date from tbl_reply where board_no = ?";
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO vo = new ReplyVO();
				vo.setReply(rs.getString("reply"));
				vo.setReplyer(rs.getString("replyer"));
				vo.setReplyDate(rs.getDate("reply_date"));
				vo.setReplyNo(rs.getInt("reply_no"));
				
				rp.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rp;
	}
	
	//상세.
	public ReplyVO selectReply(int replyNo) {
		String sql = "select reply_no, reply, replyer, reply_date from tbl_reply where reply_no =?";
		ReplyVO vo = new ReplyVO();
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			vo.setBoardNo(rs.getInt("reply_no"));
			vo.setReply(rs.getString("reply"));
			vo.setReplyer(rs.getString("replyer"));
			vo.setReplyDate(rs.getDate("reply_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return vo;
	}
	
	//등록.
	public boolean insertReply(ReplyVO vo) {
		String query = "select reply_seq.nextval from dual";
		String sql = "insert into tbl_reply (reply_no, reply, replyer, board_no)"
				+ " values (?,?,?,?)";
		
		try {
			pstmt = getConnect().prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			vo.setReplyNo(rs.getInt(1)); // rs 결과의 첫번째 컬럼.
			}
			
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setInt(1, vo.getReplyNo());
			pstmt.setString(2, vo.getReply());
			pstmt.setString(3, vo.getReplyer());
			pstmt.setInt(4, vo.getBoardNo());
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	//삭제
	public boolean delReply(int replyNo) {
		String sql ="delete from tbl_reply where reply_no = ?";
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			int r = pstmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
