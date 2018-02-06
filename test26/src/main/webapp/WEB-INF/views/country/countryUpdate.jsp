<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<script>
	$(document).ready(function() {

		// 공백들어갈시 팝업창으로 알려줌

		$('#updateButton').click(function() {
			if ($('#bookName').val() == '') {
				alert('수정할 국가 이름를 입력하세요');
				$('#countryName').focus();
			} else {
				$('#updateForm').submit();
			}
		});
	});
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
	<div class="container">
		<h2>국가 수정화면</h2>
		<form id="updateForm"
			action="${pageContext.request.contextPath}/country/countryUpdate"
			method="post">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>국가코드</th>
						<th>국가이름</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="country" items="${list}">
						<tr>
							<td><input type="text" name="countryId" readonly="readonly"
								value="${country.countryId }"></td>
							<td><input type="text" id="countryName" name="countryName"
								value="${country.countryName }"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="button" id="updateButton">수정완료</button>
		</form>
				<%-- 		<a href="${pageContext.request.contextPath}/"><button
				type="button" class="btn btn-success active">홈으로</button></a> --%>
				<a href="${pageContext.request.contextPath}/"><button
				type="button" >홈으로</button></a>
	</div>
	<!-- 부분 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp" />
	<jsp:include page="/WEB-INF/views/module/hadan.jsp" />
</body>
</html>