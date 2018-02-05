<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>아이돌 리스트</h2>
		<form action="${pageContext.request.contextPath}/idol/idolUpdate" method="post">
			<c:forEach var="i" items="${list}">
			<div>
				아이돌 번호 : <input type="text" name="idolId" readonly="readonly" value="${i.idolId}">
			</div>
			<div>
				아이돌 이름 : <input type="text" name="idolName" value="${i.idolName}">
			</div>
			</c:forEach>
			<button type="submit" class="btn btn-success active">수정</button>
		</form>
		<div>
			<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">홈으로</button></a>
		</div>
	</div>
</body>
</html>