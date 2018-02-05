<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>하면 된다</title>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">
    $(document).ready(function(){
        $('#idolButton').click(function(){
          if($('#inputidolName').val()==''){
        	  alert('내용을 입력해주세요.');
          }else {
              $('#addForm').submit();
          }
        });
    });
</script>
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
		<form class="form-inline" id="addForm" action="${pageContext.request.contextPath}/idol/idolAdd" method="post">
			<div class="row">
				<div class="col-md-4">
					<label for="title">아이돌 이름:</label>
					<input class="form-control" type="text" name="idolName" id="inputidolName">
					<button type="button" id="idolButton" class="btn btn-info">입력</button>
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