<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众号列表</title>
</head>
<body>
<random:Right_A uri="${pageContext.request.contextPath }/wechatuser/addwechatuser.action">添加公众号</random:Right_A><br />
公众号列表：
<table width="100%" border=1>
<tr>
	<td>公众号appid</td>
	<td>公众号appsecret</td>
	<td>操作</td>
</tr>
<c:forEach items="${wechatUsers}" var="wechatUser">
<tr>	
	<td>${wechatUser.appid}</td>
	<td>${wechatUser.appsecret}</td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/wechatuser/editWechatuser.action?id=${wechatUser.id}">修改</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/wechatuser/deleteWechatuser.action?id=${wechatUser.id}">删除</random:Right_A>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>