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
	<h2>리스트 목록</h2>
	<a href="${pageContext.request.contextPath}/idol/idolList">
		<button type="button" class="btn btn-info btn-block">아이돌 리스트</button>
	</a><br>
	<a href="${pageContext.request.contextPath}/book/bookList">
		<button type="button" class="btn btn-success btn-block">책 리스트</button>
	</a><br>
	<a href="${pageContext.request.contextPath}/city/cityList">
		<button type="button" class="btn btn-primary btn-block">도시 리스트</button>
	</a><br>
	<a href="${pageContext.request.contextPath}/country/countryList">
		<button type="button" class="btn btn-danger btn-block">국가 리스트</button>
	</a><br>
	<a href="${pageContext.request.contextPath}/movie/movieList">
		<button type="button" class="btn btn-warning btn-block">영화 리스트</button>
	</a>
</body>
</html>
