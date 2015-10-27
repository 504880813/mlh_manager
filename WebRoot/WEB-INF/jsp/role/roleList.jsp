<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
<body>
<random:Right_A uri="${pageContext.request.contextPath }/role/addrole.action">添加角色</random:Right_A><br />
<c:if test="${roles==null || roles.size()<=0 }">目前您没有任何角色!</c:if >
<c:if test="${roles!=null && roles.size()>0}">
角色列表：
<table width="100%" border=1>
<tr>
    <td>角色id</td>
	<td>角色名称</td>
	<td>角色值</td>
	<td>角色描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${roles}" var="role">
<tr>	
	<td>${role.id}</td>
	<td>${role.name}</td>
	<td>${role.value}</td>
	<td>${role.description}</td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/role/editrole.action?id=${role.id}">修改</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/role/deleterole.action?id=${role.id}">删除</random:Right_A>
	</td>
</tr>
</c:forEach>
</table>
</c:if>













</body>
</html>