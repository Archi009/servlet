package com.yedam.dao;

import java.lang.reflect.WildcardType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.vo.ReplyVO;

//댓글 목록, 등록 , 삭제 , 상세조회.
public class ReplyDAO extends DAO {
	
//	부서별 인원현황 차트.
	public List<Map<String, Object>> chartData() {
		String sql ="select e.department_id , d.department_name, count(1) cnt "
				+ "from employees e  "
				+ "join departments d "
				+ "on e.department_id = d.department_id "
				+ "group by e.department_id, d.department_name";
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("dep_count", rs.getInt(3));
				map.put("dep_name", rs.getString(2));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return list;
	}
	
	
	
	public int replyCount(int baordNo) {
		String sql = "select count(1) from tbl_reply where board_no = ?";
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setInt(1, baordNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);//첫번째 칼럼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return 0;
		
		
		
	}
	
	
	//목록.
	public List<ReplyVO> replyList (int boardNo, int page){
		List<ReplyVO> rp=new ArrayList<>();
		String sql = "SELECT tbl_a.*\r\n"
				+ "FROM(SELECT /*+ INDEX_DESC (r pk_reply) */ "
				+ "        rownum rn, reply_no, reply, replyer, board_no, reply_date "
				+ "FROM tbl_reply r  "
				+ "WHERE board_no = ?) tbl_a "
				+ "WHERE tbl_a.rn > (? -1) *5 "
				+ "and tbl_a.rn<= ? * 5 ";
		
		try {
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, page);
			pstmt.setInt(3, page);
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
		}finally {
			disConnect();
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
		}finally {
			disConnect();
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
		}finally {
			disConnect();
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
		}finally {
			disConnect();
		}
		
		return false;
	}
}
