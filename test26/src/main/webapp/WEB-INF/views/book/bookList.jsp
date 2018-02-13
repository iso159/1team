<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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

	<h2>Book List</h2>
	<!-- 검색 bar 부분 -->
		<form action="${pageContext.request.contextPath}/book/bookList">
		<ul class="nav top-menu">
			<li>
				<li class="page-item">
					<input class="form-control" placeholder="SearchWord" type="text" name="SearchWord" value="${SearchWord}">
					<button class="btn btn-danger"submit">검색</button>
				</li>
			</li>
		</ul>
		</form>
		
	<!--검색 bar 부분 끝 -->
			
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>책이름</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
			<tr>
				<td>${book.bookId }</td>
				<td>${book.bookName }</td>
				<td><a href="${pageContext.request.contextPath}/book/bookModify?bookId=${book.bookId}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/book/bookDelete?bookId=${book.bookId}">삭제</a></td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		<div>
			<h4>책 개수 : ${list.size()}</h4>
			<!-- n개씩보기 -->
			<select name="rowPerPage" onchange="location.href=this.value">
				<option value="#">개수 선택</option>
  				<option value="${pageContext.request.contextPath}/book/bookList?rowPerPage=5">5개씩 보기</option>
  				<option value="${pageContext.request.contextPath}/book/bookList?rowPerPage=10">10개씩 보기</option>
  				<option value="${pageContext.request.contextPath}/book/bookList?rowPerPage=15">15개씩 보기</option>
  			</select><br>
			<!-- n개씩보기 끝 -->
			
			
			<!-- 페이징 -->
			<ul class="pagination">
			<c:set var="currentPage" value="${currentPage}"/>
			<c:set var="SearchWord" value="${SearchWord}"/>
				<c:if test="${currentPage > 1}">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/book/bookList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&SearchWord=${SearchWord}">이전</a>
				</li>
				</c:if>
				<c:if test="${currentPage < lastPage}">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/book/bookList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&SearchWord=${SearchWord}">다음</a>
				</li>
				</c:if>
			</ul>
			<!-- 페이징 끝-->
			
		
		</div>
	<a href="${pageContext.request.contextPath}/book/bookAdd"><button type="button" class="btn btn-info">입력</button></a>
	<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success">홈으로</button></a>
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