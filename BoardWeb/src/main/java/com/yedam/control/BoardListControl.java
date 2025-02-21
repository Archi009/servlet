package com.yedam.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import org.apache.el.parser.AstGreaterThanEqual;

import com.yedam.pageVO;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

import oracle.jdbc.internal.KeywordValue;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//boardList.do?searchCondition=title&keyword=관심길+51-20
		
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		page = page == null ? "1" : page;
		sc = sc == null ? "" : sc;
		kw = kw == null ? "" : kw;
		System.out.println(kw);
		
		System.out.println(page);
		String name = "홍길동";
		// boardList.do -> (BaordListControl) -> boardList.jsp
		
		SearchVO sr = new SearchVO(Integer.parseInt(page),sc,kw);
		req.setAttribute("msg", name);

		BoardDAO edao = new BoardDAO();
		List<BoardVO> list = null;
		
		try {
			list = edao.selectBoard(sr);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("list", list);
		
		//페이징
		int totalCnt = edao.getTotalCount(sr);
		pageVO paging = new pageVO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", paging);
//		searchCondition, Keyword 전달
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		
		
		
//			요청 재지정 (url: boardList.do(boardList.jsp))
//		HTML jsp 페이지를 WEB-INF아래의 폴더로 이동시켜 .html 혹은 .jsp방식으로 접속하지 않고
//		.do 방식으로 무조건 컨트롤러를 거쳐 들어오게 한다.
		req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);

	}

}
