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
		<!-- 아이돌 검색 부분 -->
		<ul class="nav top-menu">
			<li>
				<form class="navbar-form" action="${pageContext.request.contextPath}/idol/idolList" method="get">
					<td><input type="hidden" name="rowPerPage" value="${map.rowPerPage}"></td>
					<input class="form-control" placeholder="Search" type="text" name="idolSearchWord">
					<button type="submit" class="btn btn-danger">검색</button>
				</form>
			</li>
		</ul>
		<!-- 아이돌 검색 부분 끝 -->
		<!-- 아이돌 데이터 테이블 -->
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
				<c:set var="list" value="${map.list}" />
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
		<!-- 아이돌 데이터 테이블 끝 -->
		<!-- 보여줄 행의 개수 작업 -->
		<div style="margin-bottom:10;">
		<select name="rowPerPage" onchange="location.href=this.value">
			<option value="#">개수 선택</option>
			<option value="${pageContext.request.contextPath}/idol/idolList?rowPerPage=5&idolSearchWord=${map.idolSearchWord}">5개씩 보기</option>
			<option value="${pageContext.request.contextPath}/idol/idolList?rowPerPage=10&idolSearchWord=${map.idolSearchWord}">10개씩 보기</option>
			<option value="${pageContext.request.contextPath}/idol/idolList?rowPerPage=15&idolSearchWord=${map.idolSearchWord}">15개씩 보기</option>
		</select><br>
		</div>
		<!-- 보여줄 행의 개수 작업 끝 -->
		<!-- 이전 다음 페이징 선택 -->
		<div>
			<a href="<c:if test="${map.startRow gt 0}">${pageContext.request.contextPath}/idol/idolList?currentPage=${map.currentPage-1}&rowPerPage=${map.rowPerPage}&idolSearchWord=${map.idolSearchWord}</c:if>">
				<button type="button" class="btn btn-info">이전</button>
			</a>
			<a href="<c:if test="${map.currentPage lt map.lastPage}">${pageContext.request.contextPath}/idol/idolList?currentPage=${map.currentPage+1}&rowPerPage=${map.rowPerPage}&idolSearchWord=${map.idolSearchWord}</c:if>">
				<button type="button" class="btn btn-success">다음</button>
			</a>
		</div>
		<!-- 이전 다음 페이징 선택 끝 -->
		<!-- 아이돌수 출력 -->
		<div style="float: right;">
			<h4>아이돌 수 : ${map.selectIdolList.size()}</h4>
		</div>
		<!-- 아이돌수 출력 끝 -->
		<!-- 아이돌 추가 및 홈으로 버튼 -->
		<div style="float: right;">
			<a href="${pageContext.request.contextPath}/idol/idolAdd">
				<button type="button" class="btn btn-info">추가</button>
			</a>
			<a href="${pageContext.request.contextPath}/">
				<button type="button" class="btn btn-success">홈으로</button>
			</a>
		</div>
		<!-- 아이돌 추가 및 홈으로 버튼 끝 -->
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