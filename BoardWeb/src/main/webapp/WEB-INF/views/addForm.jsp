<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/Header.jsp"></jsp:include>

<h3>글등록화면(addForm.jsp)</h3>
<form action="addBoard.do">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title">제목</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" rows="3" cols="45" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input class="form-control" type="text" name="writer">작성자</td>
		</tr>
		<tr>

			<td colspan="2" align="center">
			<input class="btn btn-primary" type="submit" value="등록"> 
			<input class="btn btn-danger" type="reset" value="취소">
			</td>
		</tr>
	</table>



</form>

<jsp:include page="includes/Footer.jsp"></jsp:include>