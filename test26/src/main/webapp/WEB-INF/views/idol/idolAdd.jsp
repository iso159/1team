<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이돌 입력 화면</h2>
	<form class="form-group" action="${pageContext.request.contextPath}/idol/idolAdd" method="post">
		<div>
			아이돌 이름 : <input class="form-control"  type="text" name="idolName">
			<button type="submit">입력</button>
		</div>
		
	</form>
</body>
</html>