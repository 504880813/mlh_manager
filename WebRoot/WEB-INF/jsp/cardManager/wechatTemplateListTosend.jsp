<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息模板列表</title>
</head>
<body>
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
	<random:Right_A uri="${pageContext.request.contextPath }/card/sendTemplageMessage.action?openid=${openid}&templateId=${wechatTemplate.templateId}">发送</random:Right_A>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>