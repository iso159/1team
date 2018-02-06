<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
    	
 // 공백들어갈시 팝업창으로 알려줌
 
        $('#addButton').click(function(){
          if($('#bookName').val()==''){
        	  alert('책이름을 입력하세요');
              $('#bookName').focus();
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
	<jsp:include page="../module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 네비게이션 -->
	<jsp:include page="../module/left.jsp"/>
	<!-- 네비게이션 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
		<div class="container">
			<h2>Book 입력 화면</h2>
				<form class="form-group" id="addForm" action="${pageContext.request.contextPath}/book/bookInsert" method="post">
					<table border=1>
						<tr>
							<td>책이름</td>
							<td>
								<input id="bookName" type="text" name="bookName" >
							</td>
						</tr>
					</table>
				<button type="button" id="addButton">입력완료</button>
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