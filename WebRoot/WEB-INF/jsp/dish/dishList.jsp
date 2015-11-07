<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜品列表</title>
</head>
<!-- <script type="text/javascript">

	function selectDishByType() {
		/* var value=document.getElementById("type").value; */
		document.getElementById('typeForm').submit();
	}
</script> -->
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small" uri="${pageContext.request.contextPath }/dish/addDish.action"><i class="icon-plus icon-white"></i>添加菜品</random:Right_A>
   </span>
   <strong>菜品管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						菜品管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>菜品号</strong></td>
		 <td nowrap="nowrap"><strong>菜品名</strong></td>
		  <td nowrap="nowrap"><strong>价格(元)</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${dishs}" var="dish">
			<tr align="center">	
				<td nowrap="nowrap">${dish.id}</td>
				<td nowrap="nowrap">${dish.name}</td>
				<td nowrap="nowrap">${dish.price}</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/dish/findDishdetails.action?id=${dish.id}">查看详情</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/dish/getAllImageOfdish.action?id=${dish.id}">图片集</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/dish/editDish.action?id=${dish.id}">修改基础信息</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/dish/deleteDish.action?id=${dish.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 









<%-- <random:Right_A uri="${pageContext.request.contextPath }/dish/addDish.action">添加菜品</random:Right_A><br />
分类查询菜品:
<form action="${pageContext.request.contextPath }/dish/findDishsByType.action" method="post" id="typeForm">
<select name="categoryId" onchange="selectDishByType()" id="type" >
	<option value="" selected="selected"></option>
	<c:forEach items="${ categorys}" var="Selectcategory">
	  <option value ="${ Selectcategory.id}">${Selectcategory.name}</option>
	</c:forEach> 
</select>
</form>
菜品列表：
<table width="100%" border=1>
<tr>
	<td>菜品号</td>
	<td>菜品名</td>
	<td>价格(元)</td>
	<td>操作</td>
</tr>
<c:forEach items="${dishs}" var="dish">
<tr>	
	<td>${dish.id}</td>
	<td>${dish.name}</td>
	<td>${dish.price}</td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/dish/findDishdetails.action?id=${dish.id}">查看详情</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/dish/getAllImageOfdish.action?id=${dish.id}">图片集</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/dish/editDish.action?id=${dish.id}">修改基础信息</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/dish/deleteDish.action?id=${dish.id}">删除</random:Right_A>
	</td>
</tr>
</c:forEach>
</table> --%>
</body>
</html>