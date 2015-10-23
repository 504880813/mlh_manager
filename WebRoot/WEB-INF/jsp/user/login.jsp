<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/loginSubmit.action" method="post">
	用户名<input type="text" id="username" name="username"> <br/>
	密码<input type="password" id="password" name="password"><br/>
	<input type="submit" value="submit"><br/>
</form>

</body>
</html>