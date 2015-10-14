<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡等级信息列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/card/addcardLevel.action">添加会员卡等级信息</a><br />

会员卡等级列表：
<table width="100%" border=1>
<tr>
	<td>序号</td>
	<td>名称</td>
	<td>折扣</td>
	<td>操作</td>
</tr>
<c:forEach items="${cardLevels}" var="cardLevel">
<tr>	
	<td>${cardLevel.id}</td>
	<td>${cardLevel.cardlevel}</td>
	<td>${cardLevel.discount}折</td>
	<td>
	<a href="${pageContext.request.contextPath }/card/editcardLevel.action?id=${cardLevel.id}">修改</a>
	<a href="${pageContext.request.contextPath }/card/deletecardLevel.action?id=${cardLevel.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>