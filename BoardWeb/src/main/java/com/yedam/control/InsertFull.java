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
import com.yedam.mapper.ReplyMapper;

public class InsertFull implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		Map<String, String> map = new HashMap<>();
		
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);
		
		SqlSession session = DataSource.getInstence().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		int r = mapper.insertEvent(map);
		
		
		if(r>0) {
			//{"retCode":"OK"}
			map.put("retCode", "OK");
			
//			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
//			resp.getWriter().print("{\"retCode\":\"NG\"}");
			map.put("retCode", "NG");
		}
		Gson gson =new GsonBuilder().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
		
	}

}
