package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

@WebServlet("/addStudentServ")
public class AddStudentServlet extends HttpServlet {
//	param의 값을 활용 -> db입력
//	처리성공 / 처리실패 메세지
//	get 방식은 url/header에 담아 정보를 보내준다. (빠름, 정보의 양이 제한적, 보안 취약)
//	post 방식은 body에 담아 정보를 보내준다. (문자 값 인코딩 필요 get 보다 늦음 보안업)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//요청정보의 인코딩 방식 처리
		resp.setContentType("text/html;charset=UTF-8");//응답정보의 한글에 대한 처리
		
		String sno = req.getParameter("std_no");
		String snm = req.getParameter("std_name");
		String stel = req.getParameter("tel_no");
		String saddr= req.getParameter("std_addr");
		
		StudentDAO sdao = new StudentDAO();
		
		boolean result = sdao.addStudent(new Student(sno,snm,stel,saddr));
		
		if(result) {
			resp.getWriter().print("처리성공");

		}else {
			resp.getWriter().print("처리 실패");
		}
	}
	
}
