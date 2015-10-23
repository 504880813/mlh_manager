<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改公众号</title>
</head>
<body>
公众号信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/wechatuser/${wechatuser.id ==null ? 'addwechatuserSubmit' : 'editwechatuserSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${wechatuser.id}" />
	appid<input type="text" name="appid" value="${wechatuser.appid }" />
	appsecret<input type="text" name="appsecret" value="${wechatuser.appsecret}" />
	<input type="submit" value="submit"/>
</form>
</body>
</html>