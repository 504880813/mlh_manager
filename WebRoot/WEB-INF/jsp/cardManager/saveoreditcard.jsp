<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<form action="${pageContext.request.contextPath}/card/${card.id ==null ? 'addcardSubmit' : 'editcardSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${card.id}" />
	<input type="hidden" name="isavailable" value="${card.isavailable}" />
	<input type="hidden" name="wechatOpenid" value="${card.wechatOpenid}" />
	<input type="hidden" name="allIntegral" value="${card.allIntegral}" />
	<input type="hidden" name="monthIntegral" value="${card.monthIntegral}" />
	卡号<input type="text" name="cardid" value="${card.cardid }" />
	主卡号<input type="text" name="belongsCardid" value="${card.belongsCardid}" />
	用户名<input type="text" name="username" value="${card.username}" />
	电话<input type="text" name="phone" value="${card.phone}" />
	开通金额<input type="text" name="money" value="${card.money}" />
	<input type="submit" value="submit"/>
</form>
</body>
</html>