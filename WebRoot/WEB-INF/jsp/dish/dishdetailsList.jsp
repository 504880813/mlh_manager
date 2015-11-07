<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品明细</title>
</head>
<body>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right">
   <strong>菜品明细</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						菜品明细
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>菜品号</strong></td>
         <td nowrap="nowrap">${dish.id }</td>
        </tr>
        <tr align="center">
         <td nowrap="nowrap"><strong>菜品名</strong></td>
         <td nowrap="nowrap">${dish.name }</td>
        </tr>
        <tr align="center">
         <td nowrap="nowrap"><strong>菜品类别</strong></td>
         <td nowrap="nowrap">${categoryName }</td>
        </tr>
        <tr align="center">
         <td nowrap="nowrap"><strong>价格(元)</strong></td>
         <td nowrap="nowrap">${dish.price }</td>
        </tr>
        <tr align="center">
         <td nowrap="nowrap"><strong>菜品包含原料或附属菜品名</strong></td>
         <td nowrap="nowrap">
         	<c:forEach items="${materialslist }" var="materials">
				${materials.name}:${materials.quantity}${materials.unit},
			</c:forEach>
			<c:forEach items="${auxiliarydishes }" var="auxiliarydish">
				${auxiliarydish.name }:${auxiliarydish.sub_customdish_quantity}份,
			</c:forEach>
         </td>
        </tr>
        <tr align="center">
         <td nowrap="nowrap"><strong>菜品图片</strong></td>
         <td nowrap="nowrap">
         	<c:forEach items="${dish.dishImagesList }" var="image">
				<img  src="${image.imagepath }">
			</c:forEach>
         </td>
        </tr>
        <tr align="center">
         <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         <td nowrap="nowrap"><input type="button" value="cancel" onclick="backOrColse()" /></td>
        </tr>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 


<%-- 菜品列表：
<table width="100%" border=1>
<tr>
	<td>菜品号</td>
	<td>${dish.id }</td>
</tr>
<tr>
	<td>菜品名</td>
	<td>${dish.name }</td>
</tr>
<tr>
	<td>菜品类别</td>
	<td>${categoryName }</td>
</tr>
<tr>
	<td>价格(元)</td>
	<td>${dish.price }</td>
</tr>
<tr>
	<td>菜品包含原料或附属菜品名</td><td>
	<c:forEach items="${materialslist }" var="materials">
		${materials.name}:${materials.quantity}${materials.unit},
	</c:forEach>
	<c:forEach items="${auxiliarydishes }" var="auxiliarydish">
		${auxiliarydish.name }:${auxiliarydish.sub_customdish_quantity}份,
	</c:forEach>
	</td>
</tr>
<tr>
	<td>菜品图片</td>
	<td>
	<c:forEach items="${dish.dishImagesList }" var="image">
		<img  src="${image.imagepath }">
	</c:forEach>
	</td>
</tr>
<tr>
	<td>操作</td>
	<td>
		<input type="button" value="cancel" onclick="backOrColse()" />
	</td>
</tr>
</table --%>>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dish/dishdetailsList.js"></script>
</html>