<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	<h2>Book 파일 리스트</h2>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>파일 ID</th>
				<th>파일 이름</th>
				<th>파일 확장자</th>
				<th>파일 크기</th>
				<th>첨부 파일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${bookAndBookFile.list}">
			<tr>
				<td>${b.bookFileId}</td>
				<td>${b.fileName}</td>
				<td>${b.fileExt}</td>
				<td>${b.fileSize}</td>
				<td>
					<a href="${pageContext.request.contextPath}/book/bookFileDownload?fileName=${b.fileName}&fileExt=${b.fileExt}">다운로드</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 -->
	<jsp:include page="/WEB-INF/views/module/hadan.jsp"/>
</body>
</html>