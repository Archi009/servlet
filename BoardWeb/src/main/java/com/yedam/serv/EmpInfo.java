package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

@WebServlet("/empInfo")
public class EmpInfo extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 (?eno=1001)
		resp.setContentType("text/html;charset=utf-8");
		String eno = req.getParameter("eno");
		EmpDAO	edao = new EmpDAO();
		Employee result =  edao.selectEmp(Integer.parseInt(eno));
		
		System.out.println(result.getEmpNm());
		String str = "<table border='2'>"
				+ "    <thead>\r\n"
				+ "      <tr>\r\n"
				+ "        <th>사번</th>\r\n"
				+ "        <th>이름</th>\r\n"
				+ "        <th>연락처</th>\r\n"
				+ "        <th>입사일</th>\r\n"
				+ "        <th>급여</th>\r\n"
				+ "      </tr>\r\n"
				+ "    </thead>\r\n"
				+ "    <tbody>\r\n"
				+ "      <tr>\r\n"
				+ "        <td>"+result.getEmpNo()+"</td>\r\n"
				+ "        <td>"+result.getEmpNm()+"</td>\r\n"
				+ "        <td>"+result.getTelNo()+"</td>\r\n"
				+ "        <td>"+result.getHireDate()+"</td>\r\n"
				+ "        <td>"+result.getSalary()+"</td>\r\n"
				+ "      </tr>\r\n"
				+ "    </tbody>\r\n"
				+ "  </table>"; //table tr th 사번...
		PrintWriter out = resp.getWriter(); //출력스트림
		out.print(str);
	}
}
