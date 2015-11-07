<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>初始化订单菜品</title>
</head>
<body>


<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>初始化订单菜品</strong></div>
   <div style="width:900px; margin:auto">
<form action="${pageContext.request.contextPath}/order/startOrderofdishSubmit.action" method="post">
	<input type="hidden" name="rDiningtableId" value="${order.rDiningtableId}"/>
	<input type="hidden" name="createtime" value="${startTime }" />
	<input type="hidden" name="numberofpeople" value="${order.numberofpeople }" />
	<input type="hidden" name="waiter" value="${order.waiter }" />
	<input type="hidden" name="price" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
   <!-- 	<div id="orderdishs"> -->  
     	<td align="right" bgcolor="#f1f1f1" >
     		<table id="orderdishs">
				<tr id="dishs">
					<td>菜品号</td>
					<td>菜品名称</td>
					<td>菜品单价</td>
					<td>数量(份)</td>
					<td>价格(元)</td>
					<td>操作</td>
				</tr>
			</table>
     	</td>
     	<td align="right" bgcolor="#f1f1f1">
     		总价:<span id="allprice"></span>元 
			   <table class="margin-bottom-20 table  no-border">
			        <tbody><tr>
			     	<td class="text-center"><input value="确定" name="submit" class="btn btn-info " style="width:80px;" type="submit"></td>
			     </tr>
			 	</tbody>
			  </table>
     	</td>
     </tr>
   	</tbody>
   </table>
  </form> 
   <table  class="table table-bordered">
     <tbody>
     <tr>
     	<td align="right" bgcolor="#f1f1f1" >分类</td>
     	<td align="right" bgcolor="#f1f1f1" >
     		<c:forEach items="${categorys }" var="category"  varStatus="status">
			<c:if test="${status.count==1 }">
				<input type="button" name="categoryAjax" value="all" onclick="finddishs('${pageContext.request.contextPath}')">
			</c:if>
			    <input type="button" name="categoryAjax" value="${category.name }" onclick="finddishBycategory('${pageContext.request.contextPath}','${category.id}')">
			</c:forEach>
     	</td>
     </tr>
     <tr>
     	<td align="right" bgcolor="#f1f1f1" >菜品框</td>
     	<td align="right" bgcolor="#f1f1f1" >
     			
	<div id="categorydishs">
		<table>
			<tr>
				<td>菜品号</td>
				<td>菜品名称</td>
				<td>菜品价格</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${dishs }" var="dish">
			<tr>
				<td>${dish.id }</td>
				<td class="dishName">${dish.name }</td>
				<td>${dish.price }</td>
				<td colspan="2">
				<input type="button" value="add" onclick="adddishToorderOfsetMeal('${dish.id }','${dish.name}','${dish.price }',this,'${pageContext.request.contextPath}','${dish.rcategoryid }')">
				<input type="button" value="查看详情" onclick="OpenDishDetails('${pageContext.request.contextPath}/dish/findDishdetails.action',${dish.id })">
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
    </td>
     	
     </tr>
     </tbody>
    </table>
 	
 
 
 	<!-- <div id="cardMessage"></div> -->
   </div> 
  </div>     
</div>

<%@ include file="/JspbaseTemplate/footer.jsp" %> 












<%-- 
订单信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/order/startOrderofdishSubmit.action" method="post">
	<input type="hidden" name="rDiningtableId" value="${order.rDiningtableId}"/>
	<input type="hidden" name="createtime" value="${startTime }" />
	<input type="hidden" name="numberofpeople" value="${order.numberofpeople }" />
	<input type="hidden" name="waiter" value="${order.waiter }" />
	<input type="hidden" name="price" />
	<div id="orderdishs">
		<table>
			<tr id="dishs">
				<td>菜品号</td>
				<td>菜品名称</td>
				<td>菜品单价</td>
				<td>数量(份)</td>
				<td>价格(元)</td>
				<td>操作</td>
			</tr>
		</table>
		总价:<span id="allprice"></span>元 
		<input type="submit" name="submit"  style="display:none"/>
	</div>
</form>	
	分类:<c:forEach items="${categorys }" var="category"  varStatus="status">
			<c:if test="${status.count==1 }">
				<input type="button" name="categoryAjax" value="all" onclick="finddishs('${pageContext.request.contextPath}')">
			</c:if>
			    <input type="button" name="categoryAjax" value="${category.name }" onclick="finddishBycategory('${pageContext.request.contextPath}','${category.id}')">
		</c:forEach>
	
	<div id="categorydishs">
		<table>
			<tr>
				<td>菜品号</td>
				<td>菜品名称</td>
				<td>菜品价格</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${dishs }" var="dish">
			<tr>
				<td>${dish.id }</td>
				<td class="dishName">${dish.name }</td>
				<td>${dish.price }</td>
				<td colspan="2">
				<input type="button" value="add" onclick="adddishToorderOfsetMeal('${dish.id }','${dish.name}','${dish.price }',this,'${pageContext.request.contextPath}','${dish.rcategoryid }')">
				<input type="button" value="查看详情" onclick="OpenDishDetails('${pageContext.request.contextPath}/dish/findDishdetails.action',${dish.id })">
				<form action="${pageContext.request.contextPath}/dish/findDishdetails.action" method="post">
					<input type="hidden" name="id" value="${dish.id }" />
					<input type="submit" value="查看详情">
				</form>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/startorderofdish.js"></script>
</html>