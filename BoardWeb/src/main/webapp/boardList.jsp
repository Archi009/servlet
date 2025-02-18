<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp test</title>
</head>
<body>
	<!-- html 주석 -->
	<%
	//Java 주석 <%로 싸면 자바 코드 작성가능 (jsp)
	String msg = "Hello";
	System.out.print(msg);
	%>
	<h3>반복문</h3>
	<p>
		msg의 값은
		<%=msg%></p>
	<%
	for (int i = 0; i < 10; i++) {
	%>
	<p>
		i의 값은
		<%=i * 2%></p>
	<%
	}
	%>
	<%
	//boardList.do -> reauest -> boardList.jsp
	String result = (String) request.getAttribute("msg");
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	<p>
		controller로 부터 받아온 msg의 값은
		<%=result%>
	</p>
	
		<table>
		<tbody>
	<%
	for(BoardVO board:list){
	%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><%=board.getTitle() %></td>
			<td><%=board.getContent() %></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getWriteDate() %></td>
			<td><%=board.getViewCount() %></td>
		</tr>
		
	<%
	}
	%>
	</tbody>
		</table>
</body>
</html>