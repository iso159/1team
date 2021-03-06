<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>하면 된다</title>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$('#updateBtn').click(function(){
		// 공백 제거
		let movieTitle = $.trim($('#inputidolName').val());
		if(movieTitle===""){
			// 공백일경우 경고창
			alert('공백은 입력할 수 없습니다.');
			// 텍스트 비움
			$('#inputidolName').val('');
		}else{
			// 공백이 아닐경우 서브밋
			$('#updateForm').submit();
		}
	});
});
</script>
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
		<h2>아이돌 수정</h2>
		<form id="updateForm" class="form-inline" action="${pageContext.request.contextPath}/idol/idolUpdate" method="post">
			<div class="row">
				<div class="col-md-4">
					<c:forEach var="i" items="${map.list}">
						<label for="code">아이돌 코드:</label>
						<input class="form-control" type="text" name="idolId" readonly="readonly" value="${i.idolId}">
						<label for="title">아이돌 이름:</label>
						<input class="form-control" id="inputidolName" type="text" name="idolName" value="${i.idolName}">
					</c:forEach>
					<label for="code">파일 목록</label>
					<table>
							<c:forEach var="f" items="${map.file.file}">
							<tr>
							<td>${f.fileName}${f.fileExt} size:${f.fileSize}</td>
							<td style="margin-left:10;"><a href="#">삭제</a></td>
							</tr>
							</c:forEach>
					</table>
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
	<!-- 컨테이너 부분 -->
	<jsp:include page="/WEB-INF/views/module/hadan.jsp"/>
</body>
</html>