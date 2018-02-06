<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>하면 된다</title>
</head>
<body>
	<!-- top 부분 -->
	<jsp:include page="module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="module/left.jsp"/>
	<!-- 네비게이션 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
		<!-- 첫번째 정보 -->
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<div class="info-box blue-bg">
				
				<span class="photo"><img alt="avatar" 
				src="resources/img/02.jpg"></span>
				<div class="count">진 영</div>
				<div class="title">배고팡</div>
			</div>
		</div>
		<!-- 첫번째 정보 끝 -->
		
		<!-- 두번째 정보 -->
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<div class="info-box brown-bg">
				<span class="photo"><img alt="avatar"
					src="resources/img/sis.mini.jpg"></span>
				<div class="count">송 인석</div>
				<div class="title">조장 오른손 손톱때</div>
			</div>
		</div>
		<!-- 두번째 정보 끝 -->

		<!-- 세번째 정보 -->
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<div class="info-box dark-bg">
				<!-- 이미지는 세로 90 에 가로 120으로 -->
				<!-- <span class="photo"><img alt="avatar" 
				src="resources/img/sis.mini.jpg"></span> -->
				<div class="count">리오넬 메기</div>
				<div class="title">호날두 짱</div>
			</div>
		</div>
		<!-- 세번째 정보 끝 -->

		<!-- 네번째 정보 -->
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<div class="info-box green-bg">
				<!-- 이미지는 세로 90 에 가로 120으로 -->
				<span class="photo"><img alt="avatar" 
				src="resources/img/dd.jpg"></span>
				<div class="count">김항수</div>
				<div class="title">hala ~ madrid</div>
			</div>
		</div>
		<!-- 네번째 정보 끝 -->

		<!-- 다섯번째 정보 -->
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<div class="info-box green-bg">
				<!-- 이미지는 세로 90 에 가로 120으로 -->
				<!-- <span class="photo"><img alt="avatar" 
				src="resources/img/sis.mini.jpg"></sp -->
				<div class="count">다섯번째</div>
				<div class="title">할말</div>
			</div>
		</div>
		<!-- 다섯번째 정보 끝 -->
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="module/foot.jsp"/>
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 시작 -->
	<jsp:include page="module/hadan.jsp"/>
	<!-- 컨테이너 부분 끝 -->
</body>
</html>