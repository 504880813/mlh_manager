<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{
	    margin:0px;
	    padding:0px;
	    text-align:center; 
	    background:#e9fbff;
	    background-image: url("${pageContext.request.contextPath }/images/background.jpg");
	}
</style>
<title>余额以及消费记录</title>
</head>
<body>
	<div id="first"></div>
	<div id="sec"></div>
	当前余额:${card.money }<br/>
	最近10次消费记录:<br>
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

<script type="text/javascript">
	var basepath="${pageContext.request.contextPath }";
	var appId="${chenck.appid}";
	var timestamp=${chenck.timestamp};
	var nonceStr="${chenck.nonceStr}";
	var signature="${chenck.signature}";
	var openid="${openid }";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/AccessTemlate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/showAdvertisingAndMoney.js"></script>
</html>