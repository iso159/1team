<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#updateBtn').click(function(){
			// 공백 제거
			let userPw = $.trim($('#userPw').val());
			if(userId==="" || userPw===""){
				// 공백일경우 경고창
				alert('공백은 입력할 수 없습니다.');
				// 텍스트 비움
				$('#userPw').val('');
			}else{
				// 공백이 아닐경우 서브밋
				$('#updateForm').submit();
			}
		});
	});
</script>
<title>회원수정</title>
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
		<h2>회원 수정 화면</h2>
		<form id="updateForm" class="form-inline" action="${pageContext.request.contextPath}/member/memberUpdate" method="post">
			<input type="hidden" name="memberNo" value="${loginMember.memberNo}">
			<div class="row">
				<div class="col-md-4">
					<label for="code">아이디</label>
					<input class="form-control" type="text"  name="memberId" value="${loginMember.memberId}" readonly="readonly">
					<label for="title">비밀번호</label>
					<input id="userPw" class="form-control" type="password"  name="memberPw">
					<button type="button" id="updateBtn" class="btn btn-info">수정 완료</button>
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