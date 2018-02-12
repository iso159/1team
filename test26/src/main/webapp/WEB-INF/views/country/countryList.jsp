<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
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
		<h2>국가 리스트</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>국가 번호</th>
					<th>국가 이름</th>
					<th>수정</th>
					<th>삭제</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="C" items="${CountryList}">
					<tr>
						<td>${C.countryId}</td>
						<td>${C.countryName}</td>
						<td><a
							href="${pageContext.request.contextPath}/country/countryUpdate?countryId=${C.countryId}">수정</a></td>
						<td><a
							href="${pageContext.request.contextPath}/country/countryDelete?countryId=${C.countryId}">삭제</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div>
			<h4>국가 개수 : ${CountryList.size()}</h4>
			<br>

			<!-- 보여줄 행의 개수 작업 -->
			<select name="rowPerPage" onchange="location.href=this.value">
				<option value="#">개수 선택</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=5">5개씩 보기</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=10">10개씩 보기</option>
				<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=15">15개씩 보기</option>
			</select><br>
			<!-- 페이징 처리를 위한 폼 = [다음][이전] -->
			<ul class="pagination">
				<c:set var="currentPage" value="${currentPage}" />
				<c:if test="${currentPage!=1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
					</li>
				</c:if>
				<c:if test="${currentPage!=lastPage}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
					</li>
				</c:if>
			</ul>
		</div>
		<!-- 페이징 처리를 위한 폼 = [다음][이전] 끝 -->

		<a href="${pageContext.request.contextPath}/country/countryAdd">
			<button type="button" class="btn btn-info">국가 추가</button>
		</a> <a href="${pageContext.request.contextPath}">
			<button type="button" class="btn btn-success">홈으로</button>
		</a>
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