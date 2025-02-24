package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.MemberVO;

public class MemberDAO extends DAO {
	public List<MemberVO> members () {
		String sql = "select member_id "
				+ "   ,passwd "
				+ "   ,member_name "
				+ "   ,responsbility "
				+ "   from tbl_member ";
		List<MemberVO> list = new ArrayList<>();
		
		try {
			
			pstmt = getConnect().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //조회된 값이 있으면
				MemberVO m  = new MemberVO();
				m.setMemberId(rs.getString("member_id"));
				m.setPasswd(rs.getString("passwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setResponsibiliy(rs.getNString("responsbility"));
				System.out.println(m.getMemberId());
				
				list.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return list;
	}
	
	
	public MemberVO longin (String id, String pw) {
		String sql = "select member_id "
				+ "   ,passwd "
				+ "   ,member_name "
				+ "   ,responsbility "
				+ "   from tbl_member "
				+ "	  where member_id = ? "
				+ " and passwd = ?";
		
		try {
			
			pstmt = getConnect().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery(); 
			System.out.println(rs);
			if(rs.next()) { //조회된 값이 있으면
				MemberVO m  = new MemberVO();
				m.setMemberId(rs.getString("member_id"));
				m.setPasswd(rs.getString("passwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setResponsibiliy(rs.getNString("responsbility"));
				System.out.println(m.getMemberId());
				return m;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return null;
	}
	public boolean deleteMember(String id) {
		String sql = "delete from tbl_member where member_id = ?";
		try {
			pstmt = getConnect().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
}
