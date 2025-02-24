

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- html 주석 -->
<h1>게시글 목록 (boardList.jsp)</h1>
<form action="boardList.do">
<div class="center">
	<div class="row">
	<div class="col-sm-4">
		<select name="searchCondition" class="form-control">
			<option value="">선택하세요</option>
			<option value="T" ${searchCondition == "T" ? "selected" : "" }>제목</option>
			<option value="W" ${searchCondition == "W" ? "selected" : "" }>작성자</option>
			<option value="TW" ${searchCondition == "TW" ? "selected" : "" }>제목&작성자</option>
		</select>
	</div>
<div class="col-sm-5">
		
		<input type="text" name="keyword" class="form-control" id="search" value="${keyword }">
	</div>
	<div class="col-sm-2">
		<input type="submit" value="조회" class="btn btn-success">
	</div>
</div>
</div>
</form>
<p>controller로 부터 받아온 msg의 값은 ${msg }</p>
<p>페이지 값은 ${paging }</p>
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
		<c:forEach var="board" items="${list }">
			<tr>
				<td><c:out value="${ board.boardNo}"></c:out></td>
				<td><a href="board.do?bno=${ board.boardNo}&searchCondition=${searchCondition}&keyword=${keyword}"><c:out
							value="${ board.title}"></c:out></a></td>
				<td><c:out value="${ board.content}"></c:out></td>
				<td><c:out value="${ board.writer}"></c:out></td>
				<td><c:out value="${ board.writeDate}"></c:out></td>
				<td><c:out value="${ board.viewCount}"></c:out></td>
			</tr>

		</c:forEach>
	</tbody>
</table>
<!-- paging 시작. -->
<ul class="pagination">
	<c:choose>
		<c:when test="${paging.prev}">
			<li class="page-item"><a class="page-link"
				href="boardList.do?page=${paging.startPage - 1}&searchCondition=${searchCondition }&keyword=${keyword }">Previous</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item disabled "><span class="page-link">Previous</span>
			</li>
		</c:otherwise>
	</c:choose>


	<c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
		<c:choose>
			<c:when test="${p == paging.currentPage}">


				<li class="page-item active" aria-current="page"><span
					class="page-link"><c:out value="${p }"></c:out></span></li>

			</c:when>
			<c:otherwise>

				<li class="page-item"><a class="page-link"
					href="boardList.do?page=${p }&searchCondition=${searchCondition }&keyword=${keyword }"><c:out value="${p }"></c:out></a></li>

			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${paging.next }">
			<li class="page-item"><a class="page-link"
				href="boardList.do?page=${paging.endPage + 1}&searchCondition=${searchCondition }&keyword=${keyword }">Next</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item disabled"><span class="page-link">Next</span>
			</li>
		</c:otherwise>
	</c:choose>
	
</ul>
<!-- paging 끝. -->


