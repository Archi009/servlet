package com.yedam.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
//		2종류의 파일 타입 (multipart)
		
		//요청정보의 상위 위치 getServletContext()(BoardWeb)에 있는  images 폴더의 위치 .getRealPath("images")를 가져오겠다.
		String svaerDir  = req.getServletContext().getRealPath("images");
		MultipartRequest mr = new MultipartRequest(
              
				req //1.요청객체 
				,svaerDir  //2.파일 저장 경로
				,1024*1024*5 //3.최대파일 크기
				,"utf-8"//4.인코딩 방식 
				,new DefaultFileRenamePolicy() //5.중복파일의 이름을 새로 지어주기 위한 리네임 정책
				);
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		bvo.setImg(img);
		BoardDAO bdao = new BoardDAO();
		
		if(bdao.insertBoard(bvo)) {
			
			 //forward vs. redirect
		 resp.sendRedirect("boardList.do");
		}else {
			System.err.println("실패");
		}
		
		//기존 요청인데, multipart요청은 req로 받아오질 못한다.
//		3개의 파라미터 활용 db저장.
//		addBoard.do 에서 보내오는 정보의 name들을 이용해서 값을 받아온다.
//		String title = req.getParameter("title");
//		String content = req.getParameter("content");
//		String writer = req.getParameter("writer");
//		
//		
//		BoardVO bvo = new BoardVO();
//		bvo.setTitle(title);
//		bvo.setContent(content);
//		bvo.setWriter(writer);
//		
//		
//		BoardDAO bdao = new BoardDAO();
//		
//		if(bdao.insertBoard(bvo)) {
//			
//			 //forward vs. redirect
//		 resp.sendRedirect("boardList.do");
//		}else {
//			System.err.println("실패");
//		}
		

	}

}
