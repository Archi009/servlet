package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		BoardDAO bdao = new BoardDAO();
		
		boolean r = bdao.deleteBoard(Integer.parseInt(bno));

		if (r) {
			System.out.println("삭제 성공");
			resp.sendRedirect("boardList.do?searchCondition="+searchCondition+"&keyword="+keyword);
		} else {
			System.out.println("삭제 실패");
		}

	}

}
