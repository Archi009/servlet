<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="includes/Header.jsp"></jsp:include>
	<!-- html 주석 -->

	<%
	//boardList.do -> reauest -> boardList.jsp
	String result = (String) request.getAttribute("msg");
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	<p>
		controller로 부터 받아온 msg의 값은
		<%=result%>
	</p>
	
		<table class = "table table-striped table-hover">
		<thead><tr><th>게시글 번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일자</th><th>조회수</th></tr></thead>
		<tbody>
	<%
	for(BoardVO board:list){
	%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a href="board.do?bno=<%=board.getBoardNo()%>"><%=board.getTitle() %></a></td>
			<td ><%=board.getContent() %></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getWriteDate() %></td>
			<td><%=board.getViewCount() %></td>
		</tr>
		
	<%
	}
	%>
	</tbody>
		</table>
	<jsp:include page="includes/Footer.jsp"></jsp:include>
