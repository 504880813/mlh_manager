<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改本地微信接口</title>
</head>
<body>
本地微信接口信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/wechatInterface/${wechatInterface.id ==null ? 'addwechatInterfaceSubmit' : 'editwechatInterfaceSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${wechatInterface.id}" />
	微信接口调用名称<input type="text" name="name" value="${wechatInterface.name }" />
	微信接口调用url<input type="text" name="url" value="${wechatInterface.url}" />
	微信接口描述<input type="text" name="description" value="${wechatInterface.description}" />
	<input type="submit" value="submit"/>
</form>
</body>
</html>