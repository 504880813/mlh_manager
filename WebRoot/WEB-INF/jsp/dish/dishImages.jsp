<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品图片列表</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/dish/addDishImage.action?id=${dish.id}"><i class="icon-plus icon-white"></i>添加图片</random:Right_A>
   </span>
   <strong>菜品图片管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						菜品图片管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>${dish.name }菜品图片</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${dish.dishImagesList}" var="dishImage">
			<tr align="center">	
				<td nowrap="nowrap"><img src="${dishImage.imagepath}"></td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/dish/deleteDishImage.action?dishid=${dish.id }&&imageid=${dishImage.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 


<%-- <random:Right_A uri="${pageContext.request.contextPath }/dish/addDishImage.action?id=${dish.id}">添加图片</random:Right_A><br />
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
</table> --%>
</body>
</html>