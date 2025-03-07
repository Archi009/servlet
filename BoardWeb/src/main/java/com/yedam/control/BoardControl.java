package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.pageVO;
import com.yedam.common.DataSource;
import com.yedam.control.Control;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String bno = req.getParameter("bno");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		
		SqlSession sqlSession = DataSource.getInstence().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		BoardDAO bdao = new BoardDAO();
		bdao.updateCount(Integer.parseInt(bno));
//		BoardVO board = bdao.getBaord(Integer.parseInt(bno));
		BoardVO board = mapper.getBaord(Integer.parseInt(bno));
		req.setAttribute("searchCondition", searchCondition);
		req.setAttribute("keyword", keyword);
		req.setAttribute("board", board);
		
		
		System.out.println(keyword);
		System.out.println(searchCondition);
		
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
		
	}

}
