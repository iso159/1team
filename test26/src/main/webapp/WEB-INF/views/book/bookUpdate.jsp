<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<script>
    $(document).ready(function(){
    	
 // 공백들어갈시 팝업창으로 알려줌
 
        $('#updateButton').click(function(){
          if($('#bookName').val()==''){
        	  alert('수정할 책 이름을 입력하세요');
              $('#bookName').focus();
          }else {
              $('#updateForm').submit();
          }
        });
    });
</script>
</head>
<body>
<div class="container">
	<h2>Book 수정화면</h2>
	<form id="updateForm" action="${pageContext.request.contextPath}/book/bookUpdate" method="post">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>책이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
			<tr>
				<td>
					<input type="text" name="bookId" readonly="readonly" value="${book.bookId }">
				</td>
				<td>
					<input type="text" id="bookName" name="bookName" value="${book.bookName }">
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="button" id="updateButton">수정완료</button>
	</form>
	<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">홈으로</button></a>
</div>
</body>
</html>