<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本地微信接口列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/wechatInterface/addwechatInterface.action">添加本地微信接口</a><br />
本地微信接口列表：
<table width="100%" border=1>
<tr>
	<td>微信接口调用名称</td>
	<td>微信接口调用url</td>
	<td>微信接口描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${wechatInterfaces}" var="wechatInterface">
<tr>	
	<td>${wechatInterface.name}</td>
	<td>${wechatInterface.url}</td>
	<td>${wechatInterface.description}</td>
	<td>
	<a href="${pageContext.request.contextPath }/wechatInterface/editWechatInterface.action?id=${wechatInterface.id}">修改</a>
	<a href="${pageContext.request.contextPath }/wechatInterface/deleteWechatInterface.action?id=${wechatInterface.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>