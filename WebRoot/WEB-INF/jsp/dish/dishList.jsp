<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品列表</title>
</head>
<script type="text/javascript">

	function selectDishByType() {
		/* var value=document.getElementById("type").value; */
		document.getElementById('typeForm').submit();
	}
</script>
<body>
<a href="${pageContext.request.contextPath }/dish/addDish.action">添加菜品</a><br />
分类查询菜品:
<form action="${pageContext.request.contextPath }/dish/findDishsByType.action" method="post" id="typeForm">
<select name="categoryId" onchange="selectDishByType()" id="type" >
	<option value="" selected="selected"></option>
	<c:forEach items="${ categorys}" var="Selectcategory">
	  <option value ="${ Selectcategory.id}">${Selectcategory.name}</option>
	</c:forEach> 
</select>
</form>
菜品列表：
<table width="100%" border=1>
<tr>
	<td>菜品号</td>
	<td>菜品名</td>
	<td>价格(元)</td>
	<td>操作</td>
</tr>
<c:forEach items="${dishs}" var="dish">
<tr>	
	<td>${dish.id}</td>
	<td>${dish.name}</td>
	<td>${dish.price}</td>
	<td>
	<a href="${pageContext.request.contextPath }/dish/findDishdetails.action?id=${dish.id}">查看详情</a>
	<a href="${pageContext.request.contextPath }/dish/getAllImageOfdish.action?id=${dish.id}">图片集</a>
	<a href="${pageContext.request.contextPath }/dish/editDish.action?id=${dish.id}">修改基础信息</a>
	<a href="${pageContext.request.contextPath }/dish/deleteDish.action?id=${dish.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>