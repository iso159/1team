<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#insertBtn').click(function(){
			// 공백 제거
			let movieTitle = $.trim($('#cityTitle').val());
			if(movieTitle === ""){
				// 공백일경우 경고창
				alert('공백은 입력할 수 없습니다.');
				// 텍스트 비움
				$('#cityTitle').val('');
			}else{
				// 공백이 아닐경우 서브밋
				$('#insertForm').submit();
			}
		});
	});
</script>
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
		<h2>도시 입력 화면</h2>
		<form id="insertForm" class="form-inline" action="${pageContext.request.contextPath}/city/cityAdd" 
			method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-4">
					<label for="title">도시 이름:</label>
					<input id="cityTitle" class="form-control" type="text" name="cityName" value="${city.cityName}">
					<label for="file">파일</label>
	  				<input type="file" name="file" multiple="multiple">
					<button type="button" id="insertBtn" class="btn btn-info">입력</button>
				</div>
			</div>
		</form>
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