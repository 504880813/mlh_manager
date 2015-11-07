<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/user/addUser.action">
   <i class="icon-plus icon-white"></i>添加用户</random:Right_A>
   </span>
   <strong>用户管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						用户管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>用户id</strong></td>
		 <td nowrap="nowrap"><strong>用户名称</strong></td>
		 <td nowrap="nowrap"><strong>用户密码</strong></td>
		 <td nowrap="nowrap"><strong>是否为超级管理员</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
         <c:if test="${users==null || users.size()<=0 }">
   			<tr align="center">
   				<td nowrap="nowrap"><strong>  目前您没有任何用户!</strong></td>
   			</tr>      
       	</c:if>
		<c:if test="${users!=null && users.size()>0}">
		<c:forEach items="${users}" var="user">
			<tr align="center">	
				<td nowrap="nowrap">${user.id}</td>
				<td nowrap="nowrap">${user.username}</td>
				<td nowrap="nowrap">${user.password}</td>
				<td nowrap="nowrap">${user.superadmin=='true'?'是':'否'}</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/user/editUser.action?id=${user.id}">修改</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/user/deleteUser.action?id=${user.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
		</c:if>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 










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