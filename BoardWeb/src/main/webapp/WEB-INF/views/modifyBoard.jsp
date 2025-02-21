<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/Header.jsp"></jsp:include>
<h3>수정화면 (modify).jsp)</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>

<form action="modifyBoard.do">
	<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo()%></td>
			<th>조회수</th>
			<td><%=board.getViewCount()%></td>
		</tr>
		<tr>
			<th >제목</th>
			<td colspan="3"><input name="title" class="form-control" value="<%=board.getTitle()%>"
				type="text" required></td>
		</tr>
		<tr>
			<th >내용</th>
			<td colspan="3"><textarea name="content" class="form-control" required><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=board.getWriter()%></td>
			<th>작일시</th>
			<td><%=board.getWriteDate()%></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-success">수정</button>
				
			</td>
		</tr>
	</table>
</form>
<jsp:include page="includes/Footer.jsp"></jsp:include>