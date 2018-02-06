<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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
		<h2>영화 리스트</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>영화 코드</th>
					<th>영화 이름</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${MovieList}">
					<tr>
						<td>${m.movieId}</td>
						<td>${m.movieName}</td>
						<td>
							<a href="${pageContext.request.contextPath}/movie/movieModify?movieId=${m.movieId}">수정</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/movie/movieRemove?movieId=${m.movieId}">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<h4>영화 개수 : ${MovieList.size()}</h4>
		</div>
		<a href="${pageContext.request.contextPath}/movie/movieAdd">
			<button type="button" class="btn btn-info">입력</button>
		</a>
		<a href="${pageContext.request.contextPath}/">
			<button type="button" class="btn btn-success">홈으로</button>
		</a>
	</div>
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/hadan.jsp"/>
	<!-- 컨테이너 부분 끝 -->	
</body>
</html>