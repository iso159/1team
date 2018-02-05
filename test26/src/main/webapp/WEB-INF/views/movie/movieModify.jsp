<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#updateBtn').click(function(){
			// 공백 제거
			let movieTitle = $.trim($('#movieTitle').val());
			if(movieTitle === ""){
				// 공백일경우 경고창
				alert('공백은 입력할 수 없습니다.');
				// 텍스트 비움
				$('#movieTitle').val('');
			}else{
				// 공백이 아닐경우 서브밋
				$('#updateForm').submit();
			}
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../module/top.jsp"/>
	<jsp:include page="../module/left.jsp"/>
	<h2>영화 수정 화면</h2>
	<form id="updateForm" class="form-inline" action="${pageContext.request.contextPath}/movie/movieModify" method="post">
		<div class="row">
			<div class="col-md-4">
				<label for="code">영화 코드:</label>
				<input class="form-control" type="text" name="movieId" value="${Movie.movieId}" readonly>
				<label for="title">영화 제목:</label>
				<input id="movieTitle" class="form-control" type="text" name="movieName" value="${Movie.movieName}">
				<button type="button" id="updateBtn" class="btn btn-info">수정 완료</button>
			</div>
		</div>
	</form>
</body>
</html>