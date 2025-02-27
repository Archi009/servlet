package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
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
			SqlSession session = DataSource.getInstence().openSession(true);
			BoardMapper mapper = session.getMapper(BoardMapper.class);
//			boolean r = bdao.updateBoard(vo);
			int r = mapper.updateBoard(vo);
			
			if (r>0) {
				System.out.println("수정 성공");
				resp.sendRedirect("boardList.do");
			}else {
				System.out.println("수정 실패");
			}
			
	}

}
