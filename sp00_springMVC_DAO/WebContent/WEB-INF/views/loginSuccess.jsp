<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess</title>
</head>
<body>
	<h3>${USERID }님 안녕하세요</h3>
	
	<form action="logout.kosa" method="post">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>