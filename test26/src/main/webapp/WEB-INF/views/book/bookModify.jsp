<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<script>
    $(document).ready(function(){
	 // 공백들어갈시 팝업창으로 알려줌
        $('#updateBtn').click(function(){
        	let bookName = $.trim($('#bookName').val());
	          if(bookName == ""){
	        	  alert('수정할 책 이름을 입력하세요');
		        	// 텍스트비움
		        	$('#bookName').val('');
	          }else {
	              $('#updateForm').submit();
	          }
        });
    });
</script>
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
	<h2>Book 수정화면</h2>
	<form id="updateForm" class="form-inline" action="${pageContext.request.contextPath}/book/bookModify" method="post">
		<div class="row">
			<div class="col-md-4">
				<label for="code">책코드</label>
				<input class="form-control" type="text" name="bookId" value="${book.bookId }" readonly>
				<label for="title">책 이름</label>
				<input id="bookName" class="form-control" type="text" name="bookName" value="${book.bookName }">
				<button type="button" id="updateBtn" class="btn btn-info">수정 완료</button>
			</div>
		</div>
	</form>
	
</div>
<!-- 부분 -->
<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
<jsp:include page="/WEB-INF/views/module/hadan.jsp"/>
</body>
</html>