<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡消费记录列表</title>
</head>
<body>
消费记录列表：
<table width="100%" border=1>
<tr>
	<td>卡号</td>
	<td>消费金额</td>
	<td>消费时间</td>
</tr>
<c:forEach items="${cardRecords}" var="cardRecord">
<tr>	
	<td>${cardRecord.cardId}</td>
	<td>${cardRecord.expense}</td>
	<td><fmt:formatDate value="${cardRecord.time}" type="both"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>