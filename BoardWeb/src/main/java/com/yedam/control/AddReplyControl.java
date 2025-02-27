package com.yedam.control;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		//		댓글내용, 작성자, 원본 글번호
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		String bno = req.getParameter("bno");
		System.out.println(bno);
		
//		매개값
		ReplyVO vo = new ReplyVO();
		
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setReply(reply);
		vo.setReplyer(replyer);
		
//	    DB반영
		ReplyDAO rdao = new ReplyDAO();
//		boolean run = rdao.insertReply(vo);
		SqlSession session = DataSource.getInstence().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int run = mapper.insertReply(vo);
		
//		결과값
		Map<String,Object> result = new HashMap<>();
		
		if(run>0) {
			//{"retCode":"OK"}
			result.put("retCode", "OK");
			result.put("retVal", vo);
//			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
//			resp.getWriter().print("{\"retCode\":\"NG\"}");
			result.put("retCode", "NG");
		}
		Gson gson =new GsonBuilder().create();
		String json = gson.toJson(result);
		
		resp.getWriter().print(json);
	}

}
