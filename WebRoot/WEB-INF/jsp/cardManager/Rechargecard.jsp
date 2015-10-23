<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值会员卡</title>
</head>
<body>
充值信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/card/RechargecardSubMit.action" method="post">
	<input type="hidden" name="id" value="${card.id}" />
	卡号<span>${card.cardid }</span><br>
	用户名<span>${card.username}</span><br>
	电话<span>${card.phone}</span><br>
	充值金额<input type="text" name="RechargeMoney"/>
	<input type="submit" value="submit"/>
</form>
</body>
</html>