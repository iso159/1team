<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<!-- top 부분 -->
	<jsp:include page="../module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="../module/left.jsp"/>
	<!-- 네비게이션 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
<div class="container">

	<h2>Book List</h2>
	<a href="${pageContext.request.contextPath}/book/bookInsert"><button type="button" class="btn btn-success active">추가</button></a>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>책이름</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
			<tr>
				<td>${book.bookId }</td>
				<td>${book.bookName }</td>
				<td><a href="${pageContext.request.contextPath}/book/bookUpdate?bookId=${book.bookId}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/book/bookDelete?bookId=${book.bookId}">삭제</a></td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">홈으로</button></a>
</div>
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="../module/foot.jsp"/>
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 -->
	<jsp:include page="../module/hadan.jsp"/>
</body>
</html>