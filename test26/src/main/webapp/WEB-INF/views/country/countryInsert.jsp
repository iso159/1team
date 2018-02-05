<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>국가 추가 하기</h2>
	<form class="form-group"
		action="${pageContext.request.contextPath}/country/countryInsert"
		method="post">
		<div>
			국가를 입력하세요 : <input class="form-control" type="text" >
			
			<button type="submit" name="countryName"> m </button>
		</div>
	</form>
</body>
</html>