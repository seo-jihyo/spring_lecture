<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<html><head><meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="joinDiv">
		<div class="joinTitle">JOIN PAGE</div>
		<form action="${path}/user/insertUser.do" class="joinForm" method="post">
			<div class="joinInner">
				<div>아이디</div>
				<div><input type="text" placeholder="아이디를 입력하세요." name="userid"></div>
			</div>
			<div class="joinInner">
				<div>비밀번호</div>
				<div><input type="password" placeholder="비밀번호를 입력하세요." name="pwd"></div>
			</div>
			<div class="joinBtn"><input type="submit" value="가입하기"> <input type="button" value="로그인페이지" onclick="location.href='${path}/user/login.do'"> </div>
		</form>
	</div>
</body>
</html>