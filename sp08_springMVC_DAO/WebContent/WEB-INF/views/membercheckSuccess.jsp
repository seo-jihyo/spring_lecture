<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>membercheckSuccess page</h1>

	<h2>
		<c:forEach items="${memberok }" var="ok">
			${ok.id } &nbsp; &nbsp;
			${ok.name } &nbsp; &nbsp;
			${ok.age }
			<hr>
		</c:forEach>
	</h2>
	
	<input type="button" value="뒤로가기"  onclick="javascript:location.href='check.kosa'" />
	<input type="button" value="로그인"  onclick="javascript:location.href='login.kosa'" />
</body>
</html>