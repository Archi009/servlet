package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//댓글번호	
		String rno = req.getParameter("rno");
		
		//DB.
		ReplyDAO rdao =new ReplyDAO();
//		boolean run = rdao.delReply(Integer.parseInt(rno));
		SqlSession session = DataSource.getInstence().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int run = mapper.delReply(Integer.parseInt(rno));
		
		//json
		if(run>0) {
			//{"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		}
		
	}

}
