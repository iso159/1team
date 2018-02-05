<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>하면 된다</title>
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
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="../module/foot.jsp"/>
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 -->
	<jsp:include page="../module/hadan.jsp"/>
</body>
</html>