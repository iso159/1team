<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>국가 리스트</h2>
	<table class="table table-striped">
	<thead>
		<tr>
			<th>국가 코드</th>
			<th>국가 이름</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="C" items="${CountryList}">
			<tr>
				<td>${C.countryId}</td>
				<td>${C.countryName}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">홈으로</button></a>
</div>
</body>
</html>