<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Home</title>
</head>
<body>
	<ul class="list-group">
		<li class="list-group-item list-group-item-success">
			<a href="${pageContext.request.contextPath}/idol/idolList">아이돌 리스트</a>
		</li>
		<li class="list-group-item list-group-item-info">
			<a href="${pageContext.request.contextPath}/book/bookList">책 리스트</a>
		</li>
		<li class="list-group-item list-group-item-warning">
			<a href="${pageContext.request.contextPath}/city/cityList">도시 리스트</a>
		</li>
		<li class="list-group-item list-group-item-danger">
			<a href="${pageContext.request.contextPath}/country/countryList">국가 리스트</a>
		</li>
		<li class="list-group-item list-group-item-primary">
			<a href="${pageContext.request.contextPath}/movie/movieList">영화 리스트</a>
		</li>
	</ul>
</body>
</html>
