<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>아이돌 리스트</h2>
		<table class="table table-striped">
			<tr>
				<td>아이돌아이디</td>
				<td>아이돌이름</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${list}">
					<tr>
						<td>${i.idolId}</td>
						<td>${i.idolName}</td>
						<td><a href="#">수정</a></td>
						<td><a href="#">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">홈으로</button></a>
		</div>
	</div>
</body>
</html>
