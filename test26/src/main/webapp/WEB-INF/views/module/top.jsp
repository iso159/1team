<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<!-- 부트스트랩 CSS -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- 부트스트랩 theme -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet">
<!-- 폰트 아이콘 -->
<link href="${pageContext.request.contextPath}/resources/css/elegant-icons-style.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" />
<!-- 자체 css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/fullcalendar.css">
<link href="${pageContext.request.contextPath}/resources/css/widgets.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/xcharts.min.css" rel=" stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
</head>
<body>
	<!-- top 부분 -->
	<header class="header dark-bg">
	<div class="toggle-nav">
		<div class="icon-reorder tooltips" data-original-title="Navigation" data-placement="bottom">
			<i class="icon_menu"></i>
		</div>
	</div>

	<!-- top 로고 끝 --> <a href="${pageContext.request.contextPath}/"
		class="logo">드림 <span class="lite">팀</span></a> 
	<!-- top 로고 끝-->

	<div class="nav search-row" id="top_menu">
		<!-- top 검색 부분 -->
		<ul class="nav top-menu">
			<li>
				<form class="navbar-form">
					<input class="form-control" placeholder="Search" type="text">
				</form>
			</li>
		</ul>
		<!-- top 검색 부분 끝 -->
	</div>
	<!-- top 오른쪽 선택 부분 -->
	<div class="top-nav notification-row">
		<ul class="nav pull-right top-menu">
			<!-- top 오른쪽 로그인 부분 -->
			<li id="task_notificatoin_bar" class="dropdown">
			<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
			<i class="icon-task-l"></i>
			</a>
				<ul class="dropdown-menu extended tasks-bar">
					<div class="notify-arrow notify-arrow-blue"></div>
					<li>
						<p class="blue">로그인 관리</p>
					</li>
					<li>
						<a href="#"><div class="desc">로그인</div></a>
					</li>
				</ul>
			</li>
			<!-- top 오른쪽 로그인 부분 끝 -->
			<!-- top 오른쪽 회원정보 부분 -->
			<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span class="profile-ava">
				<img alt="" src="resources/img/sis.small.jpg">
				</span> <span class="username">송 인석</span> <b class="caret"></b>
			</a>
				<ul class="dropdown-menu extended logout">
					<div class="log-arrow-up"></div>
					<li class="eborder-top"><a href="#"><i class="icon_profile"></i> 내 정보</a></li>
					<li><a href="login.html"><i class="icon_key_alt"></i> 로그아웃</a></li>
					<li><a href="documentation.html"><i class="icon_key_alt"></i>Documentation</a></li>
				</ul>
			</li>
			<!-- top 오른쪽 회원정보 부분 끝 -->
		</ul>
	</div>
	<!-- top 오른쪽 선택 부분 끝 -->
	</header>
	<!-- top 부분 끝 -->
</body>
</html>