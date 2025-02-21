
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jtsl을 쓸건데, 그것의 위치(uri)를 지정하고 사용시 호출명을 c로 하겠다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl 테스트 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>안녕하세요</h3>
	<!-- 변수 지정시 사용하는 태그 set -->
	<c:set var="msg" value="Hello"></c:set>
	<!-- 출력시 사용하는 태그 out -->
	<p>
		메세지의 값은 입니다.
		<c:out value="${msg }"></c:out>
	</p>

	<c:set var="myAge" value="15" />
	<c:if test="${myAge >= 20 }">
		<p>당신은 성인입니다.</p>
	</c:if>
	<!-- if -->
	<!-- if -->
	<!-- else -->
	<c:choose>
		
		<c:when test="${myAge >= 20 }">
			<p>당신은 성년입니다.</p>
		</c:when>
		
		<c:when test="${myAge >= 50 }">
			<p>당신은 중년입니다.</p>
		</c:when>
		
		<c:otherwise>
			<p>당신은 미성년자 입니다.</p>
		</c:otherwise>

	</c:choose>
	<!-- 반복문 시작(begin)과 끝(end)를 정하면 증가량(step)만큼 증가하면서 반복한다.(step 정의 안하면 기본값 1) -->
	<c:forEach var="i" begin="1" end="10" step="3">
	<p>${i * 2 }</p>
	</c:forEach>

</body>
</html>