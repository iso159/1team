<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>하면 된다</title>
</head>
<body>
	<!-- top 부분 -->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="/WEB-INF/views/module/left.jsp"/>
	<!-- 네비게이션 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
		<div class="container">
		<h2>아이돌 리스트</h2>
		<table class="table table-striped">
			<thead>
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
						<td><a href="${pageContext.request.contextPath}/idol/idolUpdate?idolId=${i.idolId}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/idol/idolDelete?idolId=${i.idolId}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<h4>아이돌 수 : ${list.size()}</h4>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/idol/idolAdd">
				<button type="button" class="btn btn-info">추가</button>
			</a>
			<a href="${pageContext.request.contextPath}/">
				<button type="button" class="btn btn-success">홈으로</button>
			</a>
		</div>
	</div>
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 -->
	<jsp:include page="/WEB-INF/views/module/hadan.jsp"/>
</body>
</html>