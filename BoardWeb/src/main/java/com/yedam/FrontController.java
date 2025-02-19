package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddFormControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.Control;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyControl;

/*
 * MVC 에서 Control 역할.
 * url 요청 -> 서블릿.
 */

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();//map 필드의 초기화.
	}
	
	@Override
	public void init() throws ServletException {
//		map.put("url", "servlet");  //addStudnet.do => AddStudentServlet
		map.put("/main.do", new MainControl()); //메인 화면
		map.put("/board.do", new BoardControl()); //글 상세화면
		map.put("/boardList.do", new BoardListControl()); //글목록
		map.put("/addForm.do", new AddFormControl()); 	  //글등록(화면)
		map.put("/addBoard.do", new AddBoardControl());   //글등록
		map.put("/modifyForm.do", new ModifyControl());   //글수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl());   //글수정화면
		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		http:/localhost:8080/BoardWeb/addStudent.do  =>url
//		/BoardWeb/addStudent.do => uri
		String uri = req.getRequestURI();		//"/BoardWeb/addStudent.do"
		String context = req.getContextPath(); //프로젝트 이름 "/BoardWeb"
		String page = uri.substring(context.length()); //호출페이지 구하기 "/addStudent.do"
		
		System.out.println(page);
//		map 컬랙션에서 key를 입력하면 val반환   
		
		Control control = map.get(page);
		control.exec(req, resp);
		
		
	}
}
