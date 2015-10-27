<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<random:Right_A uri="${pageContext.request.contextPath }/user/addUser.action">添加用户</random:Right_A><br />
<c:if test="${users==null || users.size()<=0 }">目前您没有任何用户!</c:if >
<c:if test="${users!=null && users.size()>0}">
用户列表：
<table width="100%" border=1>
<tr>
    <td>用户id</td>
	<td>用户名称</td>
	<td>用户密码</td>
	<td>是否是超级管理员</td>
	<td>操作</td>
</tr>
<c:forEach items="${users}" var="User">
<tr>	
	<td>${User.id}</td>
	<td>${User.username}</td>
	<td>${User.password}</td>
	<td>${User.superadmin=='true'?'是':'否'}</td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/user/editUser.action?id=${User.id}">修改</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/user/deleteUser.action?id=${User.id}">删除</random:Right_A>
	</td>
</tr>
</c:forEach>
</table>
</c:if>













</body>
</html>