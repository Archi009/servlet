package com.yedam.control;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.StudentVO;

public class MainControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<StudentVO> list = new ArrayList<>();
		
		SqlSession session = DataSource.getInstence().openSession();
	    StudentMapper mapper = session.getMapper(StudentMapper.class);
	    
	    list = mapper.showList();
	    req.setAttribute("list", list);
	    
		System.out.println(list);
		
		req.getRequestDispatcher("product/main.tiles").forward(req, resp);
	}

}
