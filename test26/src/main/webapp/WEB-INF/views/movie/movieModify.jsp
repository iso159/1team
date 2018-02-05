<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>영화 수정 화면</h2>
	<form action="${pageContext.request.contextPath}/movie/movieModify" method="post">
		<div>
			영화 코드 : <input class="form-control" type="text" name="movieId" value="${Movie.movieId}" readonly>
			영화 제목 : <input class="form-control" type="text" name="movieName" value="${Movie.movieName}">
			<button type="submit">수정 완료</button>
		</div>
	</form>
</body>
</html>