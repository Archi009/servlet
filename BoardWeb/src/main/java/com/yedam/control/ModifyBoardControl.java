package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String bno = req.getParameter("bno");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardDAO bdao = new BoardDAO();
			BoardVO vo = new BoardVO();
			
			vo.setBoardNo(Integer.parseInt(bno));
			vo.setTitle(title);
			vo.setContent(content);
			
			boolean r = bdao.updateBoard(vo);
			
			if (r) {
				System.out.println("수정 성공");
				resp.sendRedirect("boardList.do");
			}else {
				System.out.println("수정 실패");
			}
			
	}

}
