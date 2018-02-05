<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>영화 입력 화면</h2>
	<form class="form-group" action="${pageContext.request.contextPath}/movie/movieAdd" method="post">
		<div>
			영화 제목 : <input class="form-control"  type="text" name="movieName">
			<button type="submit">입력 완료</button>
		</div>
	</form>
</body>
</html>