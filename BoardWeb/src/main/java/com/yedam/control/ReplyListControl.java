package com.yedam.control;

import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		//원본 글 번호
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
//		DAO활용
		ReplyDAO rdao = new ReplyDAO();
//		List<ReplyVO> list = rdao.replyList(Integer.parseInt(bno),Integer.parseInt(page));
		Map<String, Integer> replyParam = new HashMap<>();
		replyParam.put("boardNo", Integer.parseInt(bno));
		replyParam.put("page", Integer.parseInt(page));
		SqlSession session = DataSource.getInstence().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		List<ReplyVO> list = mapper.replyList(replyParam);

//		Gson 활용
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();콘솔에 이쁘게 보여줌

	
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);  // 
//		System.out.println(json);//콘솔
		resp.getWriter().print(json);//웹브라우져
		
		
	}

}
