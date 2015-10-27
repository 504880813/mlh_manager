<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改会员卡号</title>
</head>
<body>
<br />
<!-- 读卡器设置 start-->
<object classid="clsid:8B5A1D0B-4142-4EE1-B247-56DFD7C1CACA" id="obj_ie" width="0" height="0" align="left" ></object>
<embed id="obj_firefox_chrome" type="application/mozilla-npruntime-scriptable-plugin" width=0 height=0 ><br>
<!-- 读卡器设置 end-->
<form action="${pageContext.request.contextPath}/card/ReapplyCardSubMit.action" method="post">
	<span id="message">等待读卡器接入。。。</span><br>
	旧卡号<input type="text" name="oldid" readonly="readonly" value="${oldid }"/>
	新卡号<input type="text" name="newid">
	<random:hasRight uri="ValidationCode">
	请输入验证码(顾客的微信收到的)
	<input type="text" name="PagevalidationCode">
	</random:hasRight>
	<input type="submit" value="submit"/>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/Card_reader_operation.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/ReapplyCard.js"></script>
</body>
</html>