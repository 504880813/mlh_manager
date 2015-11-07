<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
</head>
<body>



<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/right/addright.action"><i class="icon-plus icon-white"></i>添加权限</random:Right_A>
   </span>
   <strong>权限管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						权限管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>权限id</strong></td>
		 <td nowrap="nowrap"><strong>权限名称</strong></td>
		 <td nowrap="nowrap"><strong>权限url</strong></td>
		 <td nowrap="nowrap"><strong>权限描述</strong></td>
		 <td nowrap="nowrap"><strong>权限码</strong></td>
		 <td nowrap="nowrap"><strong>权限位</strong></td>
		 <td nowrap="nowrap"><strong>是否是公共资源</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
         <c:if test="${rights==null || rights.size()<=0 }">
         	<tr align="center">	
				<td nowrap="nowrap">目前您没有任何权限!</td>
         	</tr>
         </c:if >
		<c:if test="${rights!=null && rights.size()>0}">
		<c:forEach items="${rights}" var="right">
			<tr align="center">	
				<td nowrap="nowrap">${right.id}</td>
				<td nowrap="nowrap">${right.name}</td>
				<td nowrap="nowrap">${right.url}</td>
				<td nowrap="nowrap">${right.description}</td>
				<td nowrap="nowrap">${right.code}</td>
				<td nowrap="nowrap">${right.pos}</td>
				<td nowrap="nowrap">${right.common==true?'是':'否'}</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/right/editright.action?id=${right.id}">修改</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/right/deleteright.action?id=${right.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
		</c:if>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 













<%-- <random:Right_A uri="${pageContext.request.contextPath }/right/addright.action">添加权限</random:Right_A><br />
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
	<random:Right_A uri="${pageContext.request.contextPath }/right/editright.action?id=${right.id}">修改</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/right/deleteright.action?id=${right.id}">删除</random:Right_A>
	</td>
</tr>
</c:forEach>
</table>
</c:if>
 --%>












</body>
</html>