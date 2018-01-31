<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/idol/idolList">아이돌 리스트</a><br>
	<a href="${pageContext.request.contextPath}/book/bookList">책 리스트</a><br>
	<a href="${pageContext.request.contextPath}/city/cityList">도시 리스트</a><br>
	<a href="${pageContext.request.contextPath}/country/countryList">국가 리스트</a><br>
	<a href="${pageContext.request.contextPath}/movie/movieList">영화 리스트</a><br>
</body>
</html>
