<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<!-- 내용 입력 부분 -->
		<h2>${idolAndIdolFile.idolName} 파일 리스트</h2>
		<!-- 아이돌 파일 테이블 -->
		<table class="table table-striped">
			<thead>
			<tr>
				<th>파일 아이디</th>
				<th>파일 이름</th>
				<th>파일 확장자</th>
				<th>파일 사이즈</th>
				<th>삭제</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${idolAndIdolFile.file}">
					<tr>
						<td>${i.idolFileId}</td>
						<td>${i.fileName}</td>
						<td>${i.fileExt}</td>
						<td>${i.fileSize}</td>
						<td><a href="#">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 아이돌 파일 테이블 끝 -->
		<!-- 내용 입력 부분 끝 -->
		</div>
		<!-- 부트스트랩 가져온곳 삭제x -->
		<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
		<!-- 부트스트랩 가져온곳 삭제x -->
		<!-- 컨테이너 부분 -->
		<jsp:include page="/WEB-INF/views/module/hadan.jsp"/>
		<!-- 메인 화면 끝 -->
	<!-- 메인 화면 내용 부분 끝 -->
	<!-- 메인 화면  끝 -->
	</body>
</html>