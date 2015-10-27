<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品明细</title>
</head>
<body>
菜品列表：
<table width="100%" border=1>
<tr>
	<td>菜品号</td>
	<td>${dish.id }</td>
</tr>
<tr>
	<td>菜品名</td>
	<td>${dish.name }</td>
</tr>
<tr>
	<td>菜品类别</td>
	<td>${categoryName }</td>
</tr>
<tr>
	<td>价格(元)</td>
	<td>${dish.price }</td>
</tr>
<tr>
	<td>菜品包含原料或附属菜品名</td><td>
	<c:forEach items="${materialslist }" var="materials">
		${materials.name}:${materials.quantity}${materials.unit},
	</c:forEach>
	<c:forEach items="${auxiliarydishes }" var="auxiliarydish">
		${auxiliarydish.name }:${auxiliarydish.sub_customdish_quantity}份,
	</c:forEach>
	</td>
</tr>
<tr>
	<td>菜品图片</td>
	<td>
	<c:forEach items="${dish.dishImagesList }" var="image">
		<img  src="${image.imagepath }">
	</c:forEach>
	</td>
</tr>
<tr>
	<td>操作</td>
	<td>
		<input type="button" value="cancel" onclick="backOrColse()" />
	</td>
</tr>
</table>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dish/dishdetailsList.js"></script>
</html>