<%@page import="com.yedam.pageVO"%>
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

//Control에서 pagin 의 값을 얻어오기.
pageVO paging = (pageVO) request.getAttribute("paging");
%>
<p>
	controller로 부터 받아온 msg의 값은
	<%=result%>
</p>
<p>
	페이지 값은
	<%=paging%>
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO board : list) {
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a href="board.do?bno=<%=board.getBoardNo()%>"><%=board.getTitle()%></a></td>
			<td><%=board.getContent()%></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getWriteDate()%></td>
			<td><%=board.getViewCount()%></td>
		</tr>

		<%
		}
		%>
	</tbody>
</table>
<!-- paging 시작. -->
<ul class="pagination">
	<%
	if (paging.isPrev()) {
	%>
	<li class="page-item">
		<%
		} else {
		%>
	
	<li class="page-item disabled ">
		<%
		}
		%> <a class="page-link"
		href="boardList.do?page=<%=paging.getStartPage() - 1%>">Previous</a>
	</li>
	<%
	for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
		if (i == paging.getCurrentPage()) {
	%>
	<li class="page-item active" aria-current="page"><span
		class="page-link"><%=i%></span></li>
	<%
	} else {
	%>
	<li class="page-item"><a class="page-link"
		href="boardList.do?page=<%=i%>"><%=i%></a></li>
	<%
	}
	}
	%>
	<%
	if (paging.isNext() ) {
	%>
	<li class="page-item" ><%}else{ %>
	<li class="page-item disabled">
	<%} %>
	<a class="page-link" href="boardList.do?page=<%=paging.getEndPage() + 1%>">Next</a></li>
</ul>
<!-- paging 끝. -->

<jsp:include page="includes/Footer.jsp"></jsp:include>
