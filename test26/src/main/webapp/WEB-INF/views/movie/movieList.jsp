<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<!-- 검색 폼 작업 -->
		<div>
			<ul class="nav top-menu">
				<li>
						<form class="navbar-form" action="${pageContext.request.contextPath}/movie/movieList?rowPerPage=${rowPerPage}" method="GET">
							<input class="form-control" name="searchWord" placeholder="Search" type="text">
							<button type="submit" class="btn btn-danger">검색</button>
						</form>
				</li>
			</ul>
		</div>
		
		<div style="float: right;">
				<!-- 보여줄 행의 개수 작업 -->
				<select name="rowPerPage" onchange="location.href=this.value" >
					<option value="#">개수 선택</option>
	  				<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=5&searchWord=${searchWord}">5개씩 보기</option>
	  				<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=10&searchWord=${searchWord}">10개씩 보기</option>
	  				<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=15&searchWord=${searchWord}">15개씩 보기</option>
  				</select>
				<!-- 보여줄 행의 개수 작업 끝 -->
		</div>  
		<!-- 검색 폼 작업 끝 -->
		
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
						<td><a href="${pageContext.request.contextPath}/movie/movieFileList?movieId=${m.movieId}">${m.movieName}</a></td>
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
  			<!-- 이전,다음 작업 -->
  			<div>
				<ul class="pagination">
					<c:set var="currentPage" value="${currentPage}"/>
					<c:if test="${currentPage==1}">
						<li class="page-item">
	  						<a class="page-link" href="${pageContext.request.contextPath}/movie/movieList?currentPage=1&rowPerPage=${rowPerPage}&searchWord=${searchWord}">이전</a>
	  					</li>
					</c:if>
					
					<c:if test="${currentPage!=1}">
	  					<li class="page-item">
	  						<a class="page-link" href="${pageContext.request.contextPath}/movie/movieList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">이전</a>
	  					</li>
	  				</c:if>
	  				
	  				<c:if test="${currentPage!=lastPage}">
	  					<li class="page-item">
	  						<a class="page-link" href="${pageContext.request.contextPath}/movie/movieList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">다음</a>
	  					</li>
	  				</c:if>
	  				
	  				<c:if test="${currentPage==lastPage}">
	  					<li class="page-item">
	  						<a class="page-link" href="${pageContext.request.contextPath}/movie/movieList?currentPage=${lastPage}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">다음</a>
	  					</li>
	  				</c:if>
	  			</ul>
  			</div>
			<!-- 이전,다음 작업 끝 -->
			<div style="float: right;">
				<c:set var="searchWord" value="${searchWord}"></c:set>
				<c:choose>
					<c:when test="${empty searchWord}">
						<h4>총 영화 개수 : ${totalCount}</h4>
					</c:when>
					
					<c:when test="${!empty searchWord}">
						<h4>검색한 영화 개수 : ${totalCount}</h4>
					</c:when>				
				</c:choose>
				현재 페이지 : ${currentPage}<br>
			</div>
			
			<div style="float: right;">
			<a href="${pageContext.request.contextPath}/movie/movieAdd">
				<button type="button" class="btn btn-info">입력</button>
			</a>
			<a href="${pageContext.request.contextPath}/">
				<button type="button" class="btn btn-success">홈으로</button>
			</a>
			</div>			
		</div>
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