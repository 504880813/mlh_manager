<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取会员卡号</title>
</head>
<body>
<br />
<form action="${pageContext.request.contextPath}/card/PayPage.action" method="post">
	卡号<input type="text" name="cardid"/>
	<input type="submit" value="submit"/>
</form>
</body>
</html>