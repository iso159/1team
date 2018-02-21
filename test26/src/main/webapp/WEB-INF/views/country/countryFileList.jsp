<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>

<body>
	<!-- top 부분 -->
	<jsp:include page="/WEB-INF/views/module/top.jsp" />
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="/WEB-INF/views/module/left.jsp" />
	<!-- 네비게이션 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
		<h2>${countryFile.countryName} }DOWNLOAD LIST</h2>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>파일 코드</th>
					<th>파일 이름</th>
					<th>파일 확장자</th>
					<th>파일 사이즈</th>
					<th>다운로드</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="C" items="${countryFile.list}">
					<tr>
						<td>${C.countryFileId}</td>
						<td>${C.fileName}</td>
						<td>${C.fileExt}</td>
						<td>${C.fileSize}</td>

						<td><a href="/resources/upload?fileName=${C.fileName}">다운로드</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!-- 메인 화면 내용 끝 -->

	<!-- 부트스트랩 가져온곳 삭제x -->

	<jsp:include page="/WEB-INF/views/module/foot.jsp" />
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->

	<!-- 컨테이너 부분 -->
	<jsp:include page="/WEB-INF/views/module/hadan.jsp" />
</body>
</html>