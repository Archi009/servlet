package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;

public class ReplyCntControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		
		ReplyDAO rdao = new ReplyDAO();
//		int totalCnt = rdao.replyCount(Integer.parseInt(bno));
		SqlSession session = DataSource.getInstence().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int totalCnt = mapper.replyCount(Integer.parseInt(bno));
		
		
		//{"totalCnt":30}
		resp.getWriter().print("{\"totalCnt\":"+totalCnt+"}");

	}

}
