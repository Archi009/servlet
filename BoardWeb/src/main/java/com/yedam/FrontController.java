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
import com.yedam.control.AddMemberControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AjaxControl;
import com.yedam.control.ApiControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartDataControl;
import com.yedam.control.Control;
import com.yedam.control.DataControl;
import com.yedam.control.DataTableControl;
import com.yedam.control.DelFull;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.FullCalendarControl;
import com.yedam.control.FullData;
import com.yedam.control.InsertFull;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.MapControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyControl;
import com.yedam.control.RemoveMemberControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCntControl;
import com.yedam.control.ReplyListControl;

/*
 * MVC 에서 Control 역할.
 * url 요청 -> 서블릿.
 */

//@WebServlet("*.do")
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
		map.put("/modifyBoard.do", new ModifyBoardControl());   //글수정
		map.put("/deleteBoard.do", new DeleteBoardControl());   //삭제
		
//		로그인
		map.put("/loginForm.do", new LoginControl()); //화면
		map.put("/login.do", new LoginControl()); // 로그인 처리
		map.put("/logout.do", new LogoutControl()); // 로아웃 처리
		
//		관리자 test
		map.put("/memberList.do", new MemberListControl()); // 로아웃 처리
		map.put("/testAjax.do", new AjaxControl());
		map.put("/testData.do", new DataControl());
//		회원삭제
		map.put("/removeMember.do", new RemoveMemberControl());
//		회원등록
		map.put("/addMember.do", new AddMemberControl());
//		댓글등록
		map.put("/replyList.do",new ReplyListControl());
		map.put("/addReply.do",new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/getReplyCnt.do", new ReplyCntControl());
//		datatable api
		map.put("/datatable.do", new DataTableControl());
//		fullcalendar
		map.put("/full.do", new FullCalendarControl());
		map.put("/fullData.do", new FullData());
		map.put("/fullInsert.do", new InsertFull());
		map.put("/fullDel.do", new DelFull());
		
		
//		차트
		map.put("/chart.do", new ChartControl());
		map.put("/chartData.do", new ChartDataControl());
		map.put("/map.do", new MapControl());
		
		
//		api test
		map.put("/api.do", new ApiControl());
		
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
