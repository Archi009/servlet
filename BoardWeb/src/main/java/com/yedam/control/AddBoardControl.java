package com.yedam.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		3개의 파라미터 활용 db저장.
//		addBoard.do 에서 보내오는 정보의 name들을 이용해서 값을 받아온다.
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		
		BoardDAO bdao = new BoardDAO();
		
		if(bdao.insertBoard(bvo)) {
			
			 //forward vs. redirect
		 resp.sendRedirect("boardList.do");
		}else {
			System.err.println("실패");
		}
		

	}

}
