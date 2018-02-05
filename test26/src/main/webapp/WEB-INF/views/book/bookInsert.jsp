<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div class="container">
	<h2>Book 입력 화면</h2>
		<form class="form-group" action="${pageContext.request.contextPath}/book/bookInsert" method="post">
			<table border=1>
				<tr>
					<td>책이름</td>
					<td>
						<input type="text" name="bookName">
					</td>
				</tr>
			</table>
		<button type="submit">입력완료</button>
		</form>
	
</div>
</body>
</html>