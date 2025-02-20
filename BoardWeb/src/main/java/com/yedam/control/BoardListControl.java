package com.yedam.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import com.yedam.pageVO;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		
		System.out.println(page);
		String name = "홍길동";
		// boardList.do -> (BaordListControl) -> boardList.jsp

		req.setAttribute("msg", name);

		BoardDAO edao = new BoardDAO();
		List<BoardVO> list = null;
		
		try {
			list = edao.selectBoard(Integer.parseInt(page));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("list", list);
		
		//페이징
		int totalCnt = edao.getTotalCount();
		pageVO paging = new pageVO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", paging);
		
		
		
		
//			요청 재지정 (url: boardList.do(boardList.jsp))
//		HTML jsp 페이지를 WEB-INF아래의 폴더로 이동시켜 .html 혹은 .jsp방식으로 접속하지 않고
//		.do 방식으로 무조건 컨트롤러를 거쳐 들어오게 한다.
		req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);

	}

}
