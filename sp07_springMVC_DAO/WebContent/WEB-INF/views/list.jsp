<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List Page</h1>

<c:forEach items="${list }" var = "list">
	${list.deptno }
	${list.dname }
	${list.loc } <hr />
</c:forEach><p>

<input type="button" value="지점저장"	onclick="location.href='writeform.do' ">&nbsp;
<input type="button" value="Hello"	onclick="location.href='hello.do' ">&nbsp;
</body>
</html>