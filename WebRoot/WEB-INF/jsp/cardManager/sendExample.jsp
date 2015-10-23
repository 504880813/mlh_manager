<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送模板</title>
</head>
<body>
消息模板信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/card/sendTemplageMessageSubMit.action" method="post">
	<input type="hidden" name="template_id" value="${template_id}" />
	<input type="hidden" name="touser" value="${touser}" />
	金钱<input type="text" name="data['price'].value"  />
	金钱颜色<input type="text" name="data['price'].color"  />
	时间<input type="text" name="data['date'].value"  />
	时间行颜色<input type="text" name="data['date'].color"  />
	<input type="submit" value="submit"/>
</form>
</body>
</html>