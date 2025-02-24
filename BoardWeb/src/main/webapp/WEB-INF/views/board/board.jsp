

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<h3>상세화면(board.jsp)</h3>
${"Expression Language" }
<p>BoardVO 객체의 값 => ${board }</p>
<p>String 객체의 값 => ${msg }</p>
<p>String 객체의 값 => ${loginId }</p>
<form action="modifyForm.do">
	<input type="hidden" name="bno" value="${board.boardNo}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><c:out value="${ board.boardNo}"></c:out> </td>
			<th>조회수</th>
			<td><c:out value="${board.viewCount}"></c:out></td>
		</tr>
		<tr>
			<th >제목</th>
			<td colspan="3"><c:out value="${board.title}"></c:out></td>
		</tr>
		<tr>
			<th >내용</th>
			<td colspan="3"><c:out value="${board.content}"></c:out></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><c:out value="${board.writer}"></c:out></td>
			<th>작일시</th>
			<td><c:out value="${board.writeDate}"></c:out></td>
		</tr>
		<tr>
			<th >이미지</th>
			<td colspan="4"><img src="images/${board.img}"></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-success">수정</button>
				<button type="button" id="delBtn" class="btn btn-warning">삭제</button>
			</td>
		</tr>
<c:if test="${msg != null}" >
<tr align="center">
<td  colspan="4" style="color:red; font-weight:bolder;" >
${msg }
</td>
</tr>
</c:if>
	</table>
</form>
<script >
let logid = "${loginId}"
const bno = document.querySelector("input[name = 'bno']");
const user = document.querySelector("table.table>tbody>tr:nth-of-type(4)>td").innerHTML
function delBoardAjax(){
	
	console.log(user)
	console.log(logid)
	if(user==logid){
  location.href="deleteBoard.do?bno="+bno.value+"&searchCondition=${searchCondition }&keyword=${keyword }"
		
	}else{
		alert("권한을 확인하세요")
	}
  
}


document.querySelector("#delBtn").addEventListener("click",delBoardAjax)</script>
