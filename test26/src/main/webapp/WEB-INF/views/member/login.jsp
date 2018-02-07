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
	<jsp:include page="../module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="../module/left.jsp"/>
	<!-- 네비게이션 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
<div class="container">
<h2>로그인 화면</h2>
	<form id="" class="form-inline" action="${pageContext.request.contextPath}/member/login" method="post">
		<div class="row">
			<div class="col-md-4">
				<label for="code">아이디</label>
				<input class="form-control" type="text"  name="memberId" value="guest" >
				<label for="title">비밀번호</label>
				<input id="" class="form-control" type="text"  name="memberPw" value="1234">
				<button type="submit" id="" class="btn btn-info">로그인</button>
			</div>
		</div>
	</form>

</div>
	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="../module/foot.jsp"/>
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 -->
	<jsp:include page="../module/hadan.jsp"/>
</body>
</html>