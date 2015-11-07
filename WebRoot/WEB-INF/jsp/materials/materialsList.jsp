<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>原料列表</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   
   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/materials/addmaterials.action"><i class="icon-plus icon-white"></i>添加原料</random:Right_A>

   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/materials/purchase.action"><i class="icon-plus icon-white"></i>入库</random:Right_A>
   
   
   </span>
   <strong>原料管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						原料管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>原料号</strong></td>
		 <td nowrap="nowrap"><strong>原料名</strong></td>
		 <td nowrap="nowrap"><strong>库存</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${materials}" var="material">
			<tr align="center">	
				<td nowrap="nowrap">${material.id}</td>
				<td nowrap="nowrap">${material.name}</td>
				<td nowrap="nowrap">${material.surplus}${material.unit }</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/materials/editmaterials.action?id=${material.id}">修改</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/materials/deletematerials.action?id=${material.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 




<%-- <random:Right_A uri="${pageContext.request.contextPath }/materials/addmaterials.action">添加原料</random:Right_A><br />

<random:Right_A uri="${pageContext.request.contextPath }/materials/purchase.action">入库</random:Right_A><br />
原料列表：
<table width="100%" border=1>
<tr>
	<td>原料号</td>
	<td>原料名</td>
	<td>库存</td>
	<td>操作</td>
</tr>
<c:forEach items="${materials}" var="material">
<tr>	
	<td>${material.id}</td>
	<td>${material.name}</td>
	<td>${material.surplus}${material.unit }</td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/materials/editmaterials.action?id=${material.id}">修改</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/materials/deletematerials.action?id=${material.id}">删除</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/materials/findmaterialsRecord.action?id=${material.id }">查询存取记录</random:Right_A>
	</td>
</tr>
</c:forEach>
</table> --%>
</body>
</html>