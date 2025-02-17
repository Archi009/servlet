package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  서블릿 생성 (http프로토콜 통해 웹브라우저 출력)
 *  1. HttpServlet을 상속.
 *  2. WebApplicationServer(WAS) => tomcat. 자바에서 실행은 main메소드가 해줬는데, Servlet은 WAS가 해준다. 현재 우리의 WAS는 tomcat이므로 tomcat의 규격대로 진행한다.
 *  3. WAS의 실행 1)init 2)service 3)destroy
 *  
 */
public class SampleServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("init 호출. 서버실행시 최초 1번만 호출됨");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("service 호출. 호출마다 실행");
		resp.setContentType("text/html;charset=UTF-8"); // 출력스트림으로 전달 할 정보의 타입을 지정해준다.
		PrintWriter out = resp.getWriter(); // 출력 스트림 생성,클라이언트로 전달
//		for (int i = 0; i < 3; i++) {
//			
//			out.print("<h3>Hello</h3>");
//			out.print("<script>alert('hi')</script>");
//		}
//		사원 목록 출력 
		EmpDAO edao = new EmpDAO();
		List<Employee> list = edao.search(new Employee());
		for (Employee emp : list) {
			out.print("<p>사번 : <a href='empInfo?eno=" + emp.getEmpNo()+"'>"+emp.getEmpNo() +"</a>"+ "  이름 : " + emp.getEmpNm() + "   연락처 : " + emp.getTelNo() + "</p>");
		}
//		out.print(false);
//			super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 서버가 종료됨");
//		super.destroy();
	}
}
