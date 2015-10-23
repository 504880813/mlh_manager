<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>原料列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/materials/addmaterials.action">添加原料</a><br />
原料列表：
<table width="100%" border=1>
<tr>
	<td>原料号</td>
	<td>原料名</td>
	<td>库存</td>
	<td>操作</td>
</tr>
<c:forEach items="${materials}" var="material">
<tr>	
	<td>${material.id}</td>
	<td>${material.name}</td>
	<td>${material.surplus}${material.unit }</td>
	<td>
	<a href="${pageContext.request.contextPath }/materials/editmaterials.action?id=${material.id}">修改</a>
	<a href="${pageContext.request.contextPath }/materials/deletematerials.action?id=${material.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>