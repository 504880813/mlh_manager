<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改消息模板</title>
</head>
<body>
消息模板信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/wechatTemplate/${wechatTemplate.id ==null ? 'addwechatTemplateSubmit' : 'editwechatTemplateSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${wechatTemplate.id}" />
	模板名称<input type="text" name="name" value="${wechatTemplate.name }" />
	模板id<input type="text" name="templateId" value="${wechatTemplate.templateId}" />
	点击模板后的响应链接<input type="text" name="url" value="${wechatTemplate.url}" />
	模板颜色<input type="text" name="topcolor" value="${wechatTemplate.topcolor}" />
	<input type="submit" value="submit"/>
</form>
</body>
</html>