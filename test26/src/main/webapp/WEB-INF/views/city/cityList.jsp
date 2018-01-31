<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>City List</h2>
	<table border=1>
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
		<a href="${pageContext.request.contextPath}/">홈으로</a><br>
</body>
</html>