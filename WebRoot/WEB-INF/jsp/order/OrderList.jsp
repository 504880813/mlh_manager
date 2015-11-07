<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页面</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right">
   <strong>订单列表</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						订单列表
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>餐桌号</strong></td>
		 <td nowrap="nowrap"><strong>用餐人数</strong></td>
		 <td nowrap="nowrap"><strong>服务员</strong></td>
		 <td nowrap="nowrap"><strong>出菜状态</strong></td>
		 <td nowrap="nowrap"><strong>买单状态</strong></td>
		 <td nowrap="nowrap"><strong>消费金额</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${orders}" var="order">
			<tr align="center">	
				<td nowrap="nowrap">${order.diningTableName}</td>
				<td nowrap="nowrap">${order.numberofpeople}</td>
				<td nowrap="nowrap">${order.waiter}</td>
				<td nowrap="nowrap">
					<c:if test="${order.servingstatus==0 }">未上菜</c:if>
					<c:if test="${order.servingstatus==1 }">上菜中</c:if>
					<c:if test="${order.servingstatus==2 }">已上菜</c:if>
				</td>
				<td nowrap="nowrap">
					<c:if test="${!order.ispayment}">未付款</c:if>
				</td>
				<td nowrap="nowrap">${order.price}</td>
				<td nowrap="nowrap">
					<random:Right_A uri="${pageContext.request.contextPath }/order/Checkoutofdiningtableid.action?diningtableid=${order.rDiningtableId}">普通结账</random:Right_A>
					<random:Right_A uri="${pageContext.request.contextPath }/order/CheckoutofMember.action?diningtableid=${order.rDiningtableId}">会员卡结账</random:Right_A>
					<random:Right_A uri="${pageContext.request.contextPath }/order/CheckoutofMemberPhone.action?diningtableid=${order.rDiningtableId}">会员电话结账</random:Right_A>
					<random:Right_A uri="${pageContext.request.contextPath }/order/editOrderofdiningtableid.action?diningtableid=${order.rDiningtableId}">修改菜单</random:Right_A>
					<random:Right_A uri="${pageContext.request.contextPath }/order/changeOrderdiningtableofdiningtableid.action?orderid=${order.id}">修改餐桌订单</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 



<%-- 
订单列表:
<table width="100%" border=1>
<tr>
	<td>餐桌号</td>
	<td>用餐人数</td>
	<td>服务员</td>
	<td>出菜状态</td>
	<td>买单状态</td>
	<td>消费金额</td>
	<td>操作</td>
</tr>
<c:forEach items="${orders}" var="order">
<tr>	
	<td>${order.diningTableName }</td>
	<td>${order.numberofpeople }</td>
	<td>${order.waiter }</td>
	<td>
		<c:if test="${order.servingstatus==0 }">未上菜</c:if>
		<c:if test="${order.servingstatus==1 }">上菜中</c:if>
		<c:if test="${order.servingstatus==2 }">已上菜</c:if>
	</td>
	<td>
		<c:if test="${!order.ispayment}">未付款</c:if>
	</td>
	<td>${order.price}</td>
	<td>
		<random:Right_A uri="${pageContext.request.contextPath }/order/Checkoutofdiningtableid.action?diningtableid=${order.rDiningtableId}">普通结账</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/order/CheckoutofMember.action?diningtableid=${order.rDiningtableId}">会员卡结账</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/order/CheckoutofMemberPhone.action?diningtableid=${order.rDiningtableId}">会员电话结账</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/order/editOrderofdiningtableid.action?diningtableid=${order.rDiningtableId}">修改菜单</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/order/changeOrderdiningtableofdiningtableid.action?orderid=${order.id}">修改餐桌订单</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/order/edit"></random:Right_A>
	</td>
</tr>
</c:forEach>
</table> --%>
</body>
</html>