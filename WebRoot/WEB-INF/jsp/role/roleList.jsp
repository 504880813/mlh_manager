<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/role/addrole.action">
   <i class="icon-plus icon-white"></i>添加角色</random:Right_A>
   </span>
   <strong>角色管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						角色管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>角色id</strong></td>
		 <td nowrap="nowrap"><strong>角色名称</strong></td>
		 <td nowrap="nowrap"><strong>角色值</strong></td>
		 <td nowrap="nowrap"><strong>角色描述</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${roles}" var="role">
			<tr align="center">	
				<td nowrap="nowrap">${role.id}</td>
				<td nowrap="nowrap">${role.name}</td>
				<td nowrap="nowrap">${role.value}</td>
				<td nowrap="nowrap">${role.description}</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/role/editrole.action?id=${role.id}">修改</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/role/deleterole.action?id=${role.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 




<%-- <random:Right_A uri="${pageContext.request.contextPath }/role/addrole.action">添加角色</random:Right_A><br />
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
 --%>












</body>
</html>