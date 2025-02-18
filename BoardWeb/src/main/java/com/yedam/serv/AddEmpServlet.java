package com.yedam.serv;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

//init - service - destroy : servlet의 주기
@WebServlet("/addEmpServlet")
public class AddEmpServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		?empNo=1006&empNm=임성욱&telNo=010-1231
		resp.setContentType("text/html;charset=UTF-8");
	  	String eno =  req.getParameter("empNo");  //empNo의 param에 담겨있는 값
		String ename = req.getParameter("empNm");
		String tel = req.getParameter("telNo");
		
		EmpDAO dao = new EmpDAO();
		
		boolean result = dao.registerEmp(new Employee(Integer.parseInt(eno),ename,tel));
		
		if(result) {
			resp.getWriter().print("처리성공");
//			resp.sendRedirect("sample"); //addEmpServlet 에서 정상 작동되면 호출하는 sample로 이동
		}else {
			resp.getWriter().print("처리 실패");
		}
		
	}
}
