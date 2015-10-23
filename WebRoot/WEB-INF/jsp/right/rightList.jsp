<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/right/addright.action">添加权限</a><br />
<c:if test="${rights==null || rights.size()<=0 }">目前您没有任何权限!</c:if >
<c:if test="${rights!=null && rights.size()>0}">
权限列表：
<table width="100%" border=1>
<tr>
    <td>权限id</td>
	<td>权限名称</td>
	<td>权限url</td>
	<td>权限描述</td>
	<td>权限码</td>
	<td>权限位</td>
	<td>是否是公共资源</td>
	<td>操作</td>
</tr>
<c:forEach items="${rights}" var="right">
<tr>	
	<td>${right.id}</td>
	<td>${right.name}</td>
	<td>${right.url}</td>
	<td>${right.description}</td>
	<td>${right.code}</td>
	<td>${right.pos}</td>
	<td>${right.common==true?'是':'否'}</td>
	<td>
	<a href="${pageContext.request.contextPath }/right/editright.action?id=${right.id}">修改</a>
	<a href="${pageContext.request.contextPath }/right/deleteright.action?id=${right.id}">删除</a>
	</td>
</tr>
</c:forEach>
</table>
</c:if>













</body>
</html>