<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
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
		<h2>도시 리스트</h2>
		<!-- 도시 검색부분 -->
		<ul class="nav top-menu">
			<li>
			<form class="navbar-form" action="${pageContext.request.contextPath}/city/cityList" method="get">
				<input type="hidden" name="rowPerPage" value= ${rowPerPage}>
				도시이름: <input class="form-control" placeholder="Search" type="text" name="citySearchWord">
				<button type ="submit" class="btn btn-danger">검색</button>
			</form>
			</li>
		</ul>
		<!-- 도시 데이터 테이블 -->
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>도시이름</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${CityList}">
				<tr>
					<td>${i.cityId}</td>
					<td>${i.cityName}</td>
					<td><a href="${pageContext.request.contextPath}/city/cityUpdate?cityId=${i.cityId}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/city/cityRemove?cityId=${i.cityId}">삭제</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<h4>도시 개수 : ${CityList.size()}</h4>
			<!-- 보여줄 행의 개수 작업 -->
			<select name="rowPerPage" onchange="location.href=this.value">
				<option value="#">개수 선택</option>
  				<option value="${pageContext.request.contextPath}/city/cityList?rowPerPage=5">5개씩 보기</option>
  				<option value="${pageContext.request.contextPath}/city/cityList?rowPerPage=10">10개씩 보기</option>
  				<option value="${pageContext.request.contextPath}/city/cityList?rowPerPage=15">15개씩 보기</option>
  			</select><br>
  			
  			<!-- 이전,다음 작업 -->
			<ul class="pagination">
				<c:set var="currentPage" value="${currentPage}"/> <!-- currentPage = ${currentPage} -->
				<c:if test="${currentPage!=1}"> <!-- if(currentPage!=1) -->
					<li class="page-item">
  					<a class = "page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&citySearchWord=${citySearchWord}">이전</a>
  					</li>
  				</c:if>
				<c:if test="${currentPage!=lastPage}"> <!-- if(currentPage!=lastPage) -->
					<li class="page-item">
  					<a class = "page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&citySearchWord=${citySearchWord}">다음</a>
  					</li>
				</c:if> 	
		</div>
		<a href="${pageContext.request.contextPath}/city/cityAdd">
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