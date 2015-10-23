<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/category/addCategory.action">添加分类</a><br />
分类列表：
<table width="100%" border=1>
<tr>
	<td>分类号</td>
	<td>分类名</td>
	<td>操作</td>
</tr>
<c:forEach items="${categorys}" var="category">
<tr>	
	<td>${category.id}</td>
	<td>${category.name}</td>
	<td>
	<a href="${pageContext.request.contextPath }/category/editCategory.action?id=${category.id}">修改</a>
	<a href="${pageContext.request.contextPath }/category/deleteCategory.action?id=${category.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>