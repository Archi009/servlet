package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		
		BoardDAO bdao = new BoardDAO();
	
		BoardVO board = bdao.getBaord(Integer.parseInt(bno));
		
		//세션 아이디 vs. 글작성 아이디.
		HttpSession session = req.getSession();
		String id  = (String) session.getAttribute("loginId");
		String boardId = board.getWriter();
		
		if(!id.equals(boardId)) {
			req.setAttribute("msg", "권한을 확인하세요.");
			req.setAttribute("board", board);
			req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
			return;
		}
		
		req.setAttribute("board", board);	
		req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);

	}

}
