<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>餐桌列表</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right">
   <strong>餐桌选择</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						餐桌选择
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong></strong></td>
         <td nowrap="nowrap"><strong>餐桌号</strong></td>
		 <td nowrap="nowrap"><strong>是否空闲</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${diningTables}" var="diningTable">
			<tr align="center">	
				<td nowrap="nowrap">
				<c:if test="${diningTable.isfree}">
					<img alt="空闲" src="${diningTable.freeimage}">
				</c:if>
				<c:if test="${!diningTable.isfree}">
				   <img alt="繁忙" src="${diningTable.busyimage}">
				</c:if>
				</td>
				<td nowrap="nowrap">${diningTable.seatnumber}</td>
				<td nowrap="nowrap">${diningTable.isfree}</td>
				<td nowrap="nowrap">
				<c:if test="${diningTable.isfree}">
				<c:if test="${orderid==null }">
				<random:Right_A uri="${pageContext.request.contextPath }/order/startOrder.action?diningTableId=${diningTable.id}&&diningTableSeatnumber=${diningTable.seatnumber}">开台</random:Right_A>
				</c:if>
				<c:if test="${orderid!=null }">
				<random:Right_A uri="${pageContext.request.contextPath }/order/changeOrderdiningtableofdiningtableidSubmit.action?orderid=${orderid}&&newdiningtableid=${diningTable.id}">改变餐桌</random:Right_A>	
				</c:if>
				</c:if>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 


<%-- 餐桌列表：
<table width="100%" border=1>
<tr>
    <td></td>
	<td>餐桌号</td>
	<td>是否是空闲</td>
	<td>操作</td>
</tr>
<c:forEach items="${diningTables}" var="diningTable">
<tr>	
	<td>
		<c:if test="${diningTable.isfree}">
			<img alt="空闲" src="${diningTable.freeimage}">
		</c:if>
		<c:if test="${!diningTable.isfree}">
		   <img alt="繁忙" src="${diningTable.busyimage}">
		</c:if>
	</td>
	<td>${diningTable.seatnumber}</td>
	<td>${diningTable.isfree}</td>
	<td>
	<c:if test="${diningTable.isfree}">
	<c:if test="${orderid==null }">
	<random:Right_A uri="${pageContext.request.contextPath }/order/startOrder.action?diningTableId=${diningTable.id}&&diningTableSeatnumber=${diningTable.seatnumber}">开台</random:Right_A>
	</c:if>
	<c:if test="${orderid!=null }">
	<random:Right_A uri="${pageContext.request.contextPath }/order/changeOrderdiningtableofdiningtableidSubmit.action?orderid=${orderid}&&newdiningtableid=${diningTable.id}">改变餐桌</random:Right_A>	
	</c:if>
	</c:if>
	</td>
</tr>
</c:forEach>
</table> --%>
</body>
</html>