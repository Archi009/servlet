package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		BoardDAO bdao = new BoardDAO();
		SqlSession sqlSession = DataSource.getInstence().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		boolean r = bdao.deleteBoard(Integer.parseInt(bno));
		int r = mapper.deleteBoard(Integer.parseInt(bno));
		System.out.println(r+"삭제에에에에에에에에에");
		if (r>0) {
			System.out.println("삭제 성공");
			resp.sendRedirect("boardList.do?searchCondition="+searchCondition+"&keyword="+keyword);
		} else {
			System.out.println("삭제 실패");
		}

	}

}
