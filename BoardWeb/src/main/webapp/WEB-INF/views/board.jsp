<%@page import="com.yedam.vo.BoardVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/Header.jsp"></jsp:include>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
String msg = (String) request.getAttribute("msg");
String logId = (String) session.getAttribute("loginId");
%>
<h3>상세화면(board.jsp)

</h3>
<form action="modifyForm.do">
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
			<td colspan="3"><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th >내용</th>
			<td colspan="3"><%=board.getContent()%></td>
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
				<button type="button" id="delBtn" class="btn btn-warning">삭제</button>
			</td>
		</tr>
		<%if(msg != null){ %>
		<tr align="center">
<td  colspan="4" style="color:red; font-weight:bolder;" >
<%=msg %>
</td>
</tr>
<%} %>
	</table>
</form>
<script >
let logid = "<%=logId %>"
const bno = document.querySelector("input[name = 'bno']");
const user = document.querySelector("table.table>tbody>tr:nth-of-type(4)>td").innerHTML
function delBoardAjax(){
	
	console.log(user)
	console.log(logid)
	if(user==logid){
  location.href="deleteBoard.do?bno="+bno.value
		
	}else{
		alert("권한을 확인하세요")
	}
  
}


document.querySelector("#delBtn").addEventListener("click",delBoardAjax)</script>
<jsp:include page="includes/Footer.jsp"></jsp:include>