<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="container">	
	<h2>City List</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>시티이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${CityList}">
			<tr>
				<td>${i.cityId}</td>
				<td>${i.cityName}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">홈으로</button></a>
		</div>
</body>
</html>