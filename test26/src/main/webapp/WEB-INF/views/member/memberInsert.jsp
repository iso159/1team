<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="회원가입" />
<meta name="Description" content="회원가입" />
<title>회원가입</title>
<script type="text/javascript">
	//<![CDATA[
	function check() {
		var form = document.getElementById("signUpForm");
		//TODO 유효성 검사
		return true;
	}
	//]]>
</script>
</head>
<body>
	<!-- top 부분 -->
	<jsp:include page="../module/top.jsp" />
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="../module/left.jsp" />
	<!-- 네비게이션 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->

	<div id="container">
		<div id="content" style="min-height: 800px;">
			<div id="url-navi">회원가입</div>

			<!-- 본문 시작 -->
			<h1>회원가입</h1>
			<form id="signUpForm" action="${pageContext.request.contextPath}/member/memberInsert" method="post"
				onsubmit="return check()">
				<table>
					<tr>
						<td style="width: 200px;">아이디</td>
						<td style="width: 390px"><input type="text" name="memberId"
							style="width: 99%;" /></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="memberPw" style="width: 99%;" /></td>
					</tr>
					<!-- <tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="confirm" style="width: 99%;" /></td>
					</tr> -->
				</table>
				<div style="text-align: center; padding-bottom: 15px;">
					<input type="submit" value="확인" />
				</div>
			</form>
			<!--  본문 끝 -->

		</div>
		<!-- content 끝 -->
	</div>
	<!--  container 끝 -->

	<!-- 메인 화면 내용 끝 -->
	<!-- 부트스트랩 가져온곳 삭제x -->
	<jsp:include page="../module/foot.jsp" />
	<!-- 부트스트랩 가져온곳 삭제x -->
	<!-- 메인 화면 끝 -->
	<!-- 컨테이너 부분 -->
	<jsp:include page="../module/hadan.jsp" />
</body>
</html>