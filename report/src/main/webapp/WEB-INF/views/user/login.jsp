<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../include/header.jsp" %>
<html><head><meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="loginDiv">
		<div class="loginTitle">Login Page</div>
		<form class="loginForm" action="${path}/user/login_check.do" method="post">
			<div class="loginInner">
				<div>아이디</div>
				<div><input type="text" placeholder="아이디를 입력하세요." name="userid"></div>
			</div>
			<div class="loginInner">
				<div>비밀번호</div>
				<div><input type="password" placeholder="비밀번호를 입력하세요." name="passwd"></div>
			</div>
			<div class="loginBtn"><input type="submit" value="로그인"><input type="button" value="회원가입" onclick="location.href='${path}/user/join.do '"></div>
		</form>
	</div>
</body>
</html>