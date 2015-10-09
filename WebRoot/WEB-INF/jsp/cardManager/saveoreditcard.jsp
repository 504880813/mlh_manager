<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改会员卡信息</title>
</head>
<body>
会员卡信息：
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
	
	<span style="display:none" id="levelSpan">
		<c:forEach items="${levels }" var="level" varStatus="status">
			<c:if test="${!status.last}">
				${level.cardlevel },
			</c:if>
			<c:if test="${status.last}">
				${level.cardlevel }
			</c:if>
		</c:forEach>
	</span>
	
	<input type="radio" onclick="showInputdiv('true','${card.cardid }','${card.belongsCardid}','${card.username}','${card.phone}','${card.money}','${card.id!=null}')"/>主卡 
	<input type="radio" onclick="showInputdiv('false','${card.cardid }','${card.belongsCardid}','${card.username}','${card.phone}','${card.money}','${card.id!=null}')"/>副卡 
	
	
	<div id="cardMessage"></div>
	<input type="submit" value="submit"/>
</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/saveoredit.js"></script>
</html>