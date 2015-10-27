<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品图片列表</title>
</head>
<body>
<random:Right_A uri="${pageContext.request.contextPath }/dish/addDishImage.action?id=${dish.id}">添加图片</random:Right_A><br />
菜品图片列表：
<table width="100%" border=1>
<tr>
	<td>${dish.name }菜品图片</td>
	<td>操作</td>
</tr>
<c:forEach items="${dish.dishImagesList}" var="dishImage">
<tr>	
	<td><img src="${dishImage.imagepath}"></td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/dish/deleteDishImage.action?dishid=${dish.id }&&imageid=${dishImage.id}">删除</random:Right_A>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>