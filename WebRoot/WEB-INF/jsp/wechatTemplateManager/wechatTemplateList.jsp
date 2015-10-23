<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息模板列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/wechatTemplate/addwechatTemplate.action">添加消息模板</a><br />
消息模板列表：
<table width="100%" border=1>
<tr>
	<td>消息模板名称</td>
	<td>消息模板id</td>
	<td>消息模板点击后响应链接</td>
	<td>消息模板背景色</td>
	<td>操作</td>
</tr>
<c:forEach items="${wechatTemplates}" var="wechatTemplate">
<tr>	
	<td>${wechatTemplate.name}</td>
	<td>${wechatTemplate.templateId}</td>
	<td>${wechatTemplate.url}</td>
	<td>${wechatTemplate.topcolor}</td>
	<td>
	<a href="${pageContext.request.contextPath }/wechatTemplate/editWechatTemplate.action?id=${wechatTemplate.id}">修改</a>
	<a href="${pageContext.request.contextPath }/wechatTemplate/deleteWechatTemplate.action?id=${wechatTemplate.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>