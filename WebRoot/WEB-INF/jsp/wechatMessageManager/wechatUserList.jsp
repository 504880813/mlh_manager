<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众号列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/wechatuser/addwechatuser.action">添加公众号</a><br />
公众号列表：
<table width="100%" border=1>
<tr>
	<td>公众号appid</td>
	<td>公众号appsecret</td>
	<td>操作</td>
</tr>
<c:forEach items="${wechatUsers}" var="wechatUser">
<tr>	
	<td>${wechatUser.appid}</td>
	<td>${wechatUser.appsecret}</td>
	<td>
	<a href="${pageContext.request.contextPath }/wechatuser/editWechatuser.action?id=${wechatUser.id}">修改</a>
	<a href="${pageContext.request.contextPath }/wechatuser/deleteWechatuser.action?id=${wechatUser.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>