<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缴费页面</title>
</head>
<body>
<br />
<form id="paypageForm" action="${pageContext.request.contextPath}/card/PayPageSubMit.action" method="post">
	卡号<input type="text" name="cardId" value="${card.cardid }"/>
	消费金额<input type="text" name="expense" onchange="expenseChange()"/>
	会员卡余额<span id="cardMoney">${card.money }</span>
	应付款现金<span id="otherMoney">0元</span>
	<input type="button" value="submit" onclick="submitPage(this)"/>
</form>
</body>
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jDialog/jDialog.css" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.drag.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.mask.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.dialog.js" ></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/PayPage.js"></script>
</html>