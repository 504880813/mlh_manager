<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本地微信接口列表</title>
</head>
<body>


<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/wechatInterface/addwechatInterface.action">
   <i class="icon-plus icon-white"></i>添加本地微信接口</random:Right_A>
   </span>
   <strong>本地微信接口管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						本地微信接口管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>微信接口调用名称</strong></td>
		 <td nowrap="nowrap"><strong>微信接口调用url</strong></td>
		 <td nowrap="nowrap"><strong>微信接口描述</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${wechatInterfaces}" var="wechatInterface">
			<tr align="center">	
				<td nowrap="nowrap">${wechatInterface.name}</td>
				<td nowrap="nowrap">${wechatInterface.url}</td>
				<td nowrap="nowrap">${wechatInterface.description}</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/wechatInterface/editWechatInterface.action?id=${wechatInterface.id}">修改</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/wechatInterface/deleteWechatInterface.action?id=${wechatInterface.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 







<%-- <random:Right_A uri="${pageContext.request.contextPath }/wechatInterface/addwechatInterface.action">添加本地微信接口</random:Right_A><br />
本地微信接口列表：
<table width="100%" border=1>
<tr>
	<td>微信接口调用名称</td>
	<td>微信接口调用url</td>
	<td>微信接口描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${wechatInterfaces}" var="wechatInterface">
<tr>	
	<td>${wechatInterface.name}</td>
	<td>${wechatInterface.url}</td>
	<td>${wechatInterface.description}</td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/wechatInterface/editWechatInterface.action?id=${wechatInterface.id}">修改</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/wechatInterface/deleteWechatInterface.action?id=${wechatInterface.id}">删除</random:Right_A>
	</td>
</tr>
</c:forEach>
</table> --%>
</body>
</html>