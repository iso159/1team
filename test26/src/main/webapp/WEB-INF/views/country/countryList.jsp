<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script src="d5.js" type="text/javascript"></script>
<script>
	$("#C").click(function() {
	  var result = '${msg}';
	  if (result == "success")
	    alert('처리가 완료되었습니다.');
</script>
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
		<h2>국가 리스트</h2>

		<!-- 검색 기능 시작 -->
		<div>
			<ul class="nav top-menu">
				<li>
					<form class="navbar-form" action="${pageContext.request.contextPath}/country/countryList?rowPerPage=${rowPerPage}" method="get">
						<input class="form-control" name="searchWord" placeholder="Search" type="text">
						<button type="submit" class="btn btn-danger">검색</button>
					</form>
				</li>
			</ul>
		</div>
		<!-- 검색 기능 끝 -->

		<!-- 보여줄 행의 개수 작업 -->
		<div style="float: right;">
			<select name="rowPerPage" onchange="location.href=this.value">
				<option value="#">10개씩 보기</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=5&searchWord=${searchWord}">5개씩 보기</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=10&searchWord=${searchWord}">10개씩 보기</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=30&searchWord=${searchWord}">30개씩 보기</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=50&searchWord=${searchWord}">50개씩 보기</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=100&searchWord=${searchWord}">100개씩 보기</option>
			</select>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>국가 코드</th>
					<th>국가 이름</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="C" items="${CountryList}">
					<tr>
						<td>${C.countryId}</td>
						<td><a href="${pageContext.request.contextPath}/country/countryFileList?countryId=${C.countryId}">${C.countryName}</a></td>
						<td><a href="${pageContext.request.contextPath}/country/countryModify?countryId=${C.countryId}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/country/countryDelete?countryId=${C.countryId}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<h4>국가 개수 : ${CountryList.size()}</h4>
			<br>

			<!-- 페이징 처리 [다음][이전] 시작 -->
			 <ul class="pagination">
				<c:set var="currentPage" value="${currentPage}" />
				<c:if test="${currentPage!=1}">
					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">이전</a></li>
				</c:if>
				<c:if test="${currentPage!=lastPage}">
					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">다음</a></li>
				</c:if>
				
				
			</ul> 
		</div>

		<!-- 페이징 처리 [다음][이전] 끝 -->
		<div style="float: right;">
			<c:set var="searchWord" value="${searchWord}"></c:set>
			<c:choose>
				<c:when test="${empty searchWord}">
					<h4>총 국가 개수 : ${totalCount}</h4>
				</c:when>

				<c:when test="${!empty searchWord}">
					<h4>검색한 국가 개수 : ${totalCount}</h4>
				</c:when>
			</c:choose>
			현재 페이지 : ${currentPage}<br>
		</div>
			
		<div style="float: right;">
			<a href="${pageContext.request.contextPath}/country/countryAdd">
				<button type="button" class="btn btn-info">국가 추가</button></a> 
			<a href="${pageContext.request.contextPath}">
				<button type="button" class="btn btn-success">홈으로</button>
			</a>
		</div>
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