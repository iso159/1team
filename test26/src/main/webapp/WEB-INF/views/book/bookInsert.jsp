<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('#insertBtn').click(function(){
        	// 공백들어갈시 팝업창으로 알려줌
        	let bookName = $.trim($('#bookName').val());
	          if(bookName == ""){
	        	  alert('책이름을 입력하세요');
	        	  // 텍스트비움
	        	  $('#bookName').val('');
	          }else {
	              $('#addForm').submit();
	          }
        });
    });
</script>
<title>하면 된다</title>
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
			<h2>Book 입력 화면</h2>
				<form class="form-inline" id="addForm" action="${pageContext.request.contextPath}/book/bookInsert" method="post">
					<div class ="row">
						<div class="col-md-4">
							<label for="title">책이름</label>
							<input id="bookName" class="form-control" type="text" name="bookName" >
							<button type="button" id="insertBtn" class="btn btn-info">입력 완료</button>
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