<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--업데이트 양식등 만듬--%>
<%--
@RequestParam String userid,
@RequestParam String passwd
--%>

<div class="updateDiv">
    <div class="updateTitle">Update Page</div>
    <form class="updateForm" action="${path}/user/update.do" method="post">
        <div class="updateInner">
            <div>비밀번호</div>
            <div><input type="password" name="passWd" ></div>
        </div>
        <div class="updateBtn">
        <input type="hidden" name="userId" value="${dto.userId}"/>
        <div><input type="submit" value="수정하기"></div>
    </form>
</div>

</body>
</html>
