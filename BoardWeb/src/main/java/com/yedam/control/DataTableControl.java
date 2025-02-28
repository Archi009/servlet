package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class DataTableControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		
	    SqlSession session = DataSource.getInstence().openSession();
	    ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	    List<ReplyVO> list = mapper.replyListDtable(Integer.parseInt(bno));
	    Map<String, List<ReplyVO> > map = new HashMap<>();
	    map.put("data", list);
	    Gson gson = new GsonBuilder().create();
	    String json = gson.toJson(map);
	    resp.getWriter().write(json);
	    
	}

}
