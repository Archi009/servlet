package com.yedam.control;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.CalVO;

public class DelFull implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// JSON 데이터 읽기
		req.setCharacterEncoding("UTF-8");
		BufferedReader reader = req.getReader();
		Gson gson = new GsonBuilder().create();
		CalVO event = gson.fromJson(reader, CalVO.class);
//        event.setStart("2025-02-09");
//        event.setTitle("서귀포시 출장");
//        event.setEnd("2025-02-20");
		SqlSession session = DataSource.getInstence().openSession();
		System.out.println(event.getTitle());
		System.out.println(event.getEnd());
		System.out.println(event.getStart());
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		System.out.println(event);
		int r = mapper.delEvent(event);

		if (r > 0) {
        	session.commit(true);
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}

	}

}
