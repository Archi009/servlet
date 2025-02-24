<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h3>글등록화면(addForm.jsp)</h3>
<!-- form 태그엔  enctype = "application/x-www-form-urlencoded" 가 기본으로 설정돼있다.(저 형식으로 보내겠다)
 이는 name에 값을 담아 보내는 설정을 뜻하는데 , 이미지 파일을 넣기 위해 multipart어쩌구로 바꿨다
-->
<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title" required></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" rows="3" cols="45" name="content" required></textarea></td>
		</tr>
		<tr >
			<th>작성자</th>
			<td><input class="form-control"  name="writer" value="${loginId }" style="border:0" readonly></td>
		</tr>
		<tr >
			<th>이미지</th>
			<td><input class="form-control"  name="img" type="file"  ></td>
		</tr>
		<tr>

			<td colspan="2" align="center">
			<input class="btn btn-primary" type="submit" value="등록"> 
			<input class="btn btn-danger" type="reset" value="취소">
			</td>
		</tr>
	</table>



</form>

