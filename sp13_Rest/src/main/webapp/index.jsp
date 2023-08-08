<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1. 문자열 처리 -->
<a href="getText">1.문자열 반환</a><hr>

<!-- 2. 객체 반환 -->
<a href="getObject">2.Object Return</a><hr>

<!-- 3. List Object-->
<a href="getList">3. List Object Return</a><hr>

<!-- 4. 쿼리 스트링 처리-->
<a href="sample/it/100">4. 쿼리 스트링 처리</a><hr>
<a href="sample/novel/3030">4. 쿼리 스트링 처리</a>

<!-- 5. POST-->
<form action="sample/data" method="post">
	<input type="text" name="name" placeholder="name"><br>
	<input type="text" name="age" placeholder="age"><br>
	<input type="text" name="message" placeholder="message"><br>
	<input type="submit" value="POST 전송">
</form>
</body>
</html>