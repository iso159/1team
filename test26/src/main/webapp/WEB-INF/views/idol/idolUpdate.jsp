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
        	  alert('공백은 불가능합니다.');
          }else {
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
					<c:forEach var="i" items="${list}">
					<div>
						아이돌 번호 : <input type="text" name="idolId" readonly="readonly" value="${i.idolId}">
					</div>
					<div>
						아이돌 이름 : <input id="inputidolName" type="text" name="idolName" value="${i.idolName}">
					</div>
					</c:forEach>
					<div>
					<button type="button" id="idolButton" class="btn btn-info">수정</button>
					<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">홈으로</button></a>
					</div>
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