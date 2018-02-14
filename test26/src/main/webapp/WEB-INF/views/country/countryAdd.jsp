<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>하면 된다</title>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
</head>
<script>
	$(document).ready(function() {
		$('#insertBtn').click(function() {
			// 공백 제거
			let countryTitle = $.trim($('#countryTitle').val());
			if (countryTitle === "") {
				// 공백일경우 경고창
				alert('공백은 입력할 수 없습니다.');
				// 텍스트 비움
				$('#countryTitle').val('');
			} else {
				// 공백이 아닐경우 서브밋
				$('#insertForm').submit();
			}
		});
	});
</script>
<body>
	<!-- top 부분 -->
	<jsp:include page="../module/top.jsp" />
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="../module/left.jsp" />
	<!-- 네비게이션 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
		<form id="insertForm" class="form-inline" action="${pageContext.request.contextPath}/country/countryAdd" method="post">
		<div class="row">
			<div class="col-md-4">
				<label for="title">국가 이름:</label>
				<input id="countryTitle" class="form-control"  type="text" name="countryName">
				<button type="button" id="insertBtn" class="btn btn-info">입력 완료</button>
			</div>
		</div>
	</form>
	</div>
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="../module/foot.jsp" />
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 -->
	<jsp:include page="../module/hadan.jsp" />
</body>
</html>