<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结账界面</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>结账界面</strong></div>
   <div style="width:900px; margin:auto">
 <form id="chenckForm" action="${pageContext.request.contextPath}/order/Checkout.action" method="post">
	<input type="hidden" name="id" value="${order.id }"/>
	<input type="hidden" name="rDiningtableId" value="${order.rDiningtableId}"/>
	<input type="hidden" name="createtime" value="${endtime }" />
	<input type="hidden" name="numberofpeople" value="${order.numberofpeople }" />
	<input type="hidden" name="waiter" value="${order.waiter }" />
   <table id="table_print"  class="table table-bordered">
      <tr>
       <td width="10%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" >桌号</td>
       <td width="23%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" id="diningTableName">
	       ${order.diningTableName }
	   </td>
	   <td width="10%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" >服务员</td>
       <td width="23%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" >
	       ${order.waiter}
	   </td>
	    <td width="10%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" >时间</td>
       <td width="23%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" >
	       ${endtime}
	   </td>
     </tr>
     
      <tr>
     	<td width="100%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="6">正常菜</td>
     </tr>
     <tr>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">菜品名</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">数量</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">总价</td>
     </tr>
     
   <c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==1 }">
			<tr>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishName}</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishnumber}</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	<tr>
     	<td width="100%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="6">
     	加菜
     	</td>
     </tr>
     <tr>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">菜品名</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">数量</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">总价</td>
     </tr>
     <c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==2 }">
			<tr>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishName}</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishnumber}</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
      <tr>
     	<td width="100%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="6">
     		退菜
     	</td>
     </tr>
     <tr>
 		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">菜品名</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">数量</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">总价</td>
     </tr>
     <c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==0 }">
			<tr>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishName}</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishnumber}</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	<tr>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">菜品总价</td>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="4">
			<span id="allprice">${order.price}</span>元
			<input type="hidden" name="price" value="${order.price}" />
		</td>
	</tr>
	<tr>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">折扣</td>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="4">
			<input type="text" name="discountamountPercent" id="discountamountPercent" onchange="CalculatingDiscount(this)">折
			<span id="discountamountValue"></span>元<br>
			<input type="hidden" name="discountamount"/>
		</td>
	</tr>
	<tr>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">优惠券</td>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="4">
			<input type="text" name="couponamount" id="couponamount" onchange="changeAllprice()">元<br>
			<input type="hidden" name="price" value="${order.price}">
		</td>
	</tr>
	<tr>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">应付</td>
		<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="4">
			<span id="showpayprice">${order.price}</span> 
		</td>
	</tr>
   </table>
   <table class="margin-bottom-20 table  no-border">
        <tbody><tr>
     	<td class="text-center">
     	<input value="付款" name="payment" class="btn btn-info" style="width:80px;" type="button" onclick="pay('true')">
     	</td>
     	<td class="text-center">
     	<input value="签单" name="writtenPermission" class="btn btn-info" style="width:80px;" type="button" onclick="pay('false')">
     	</td>
     	<td class="text-center">
     	<input value="返回" name="cancel" class="btn btn-info " style="width:80px;" type="button" onclick="back()">
     	</td>
     </tr>
 	</tbody>
  </table>
 	<!-- <div id="cardMessage"></div> -->
   </form>   
   </div> 
  </div>     
</div>

<%@ include file="/JspbaseTemplate/footer.jsp" %> 










<%-- 

订单详情：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />

<form action="${pageContext.request.contextPath}/order/Checkout.action" method="post">
	<input type="hidden" name="id" value="${order.id }"/>
	<input type="hidden" name="rDiningtableId" value="${order.rDiningtableId}"/>
	<input type="hidden" name="createtime" value="${endtime }" />
	<input type="hidden" name="numberofpeople" value="${order.numberofpeople }" />
	<input type="hidden" name="waiter" value="${order.waiter }" />
	桌号:${order.diningTableName }<br /> 
	服务员${order.waiter}<br />
	时间${endtime}<br />
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	正常菜<table>
	<tr>
	<td>菜品名</td><td>数量</td><td>价格</td>
	</tr>
	<c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==1 }">
			<tr>
			<td>${orderdetail.dishName}</td><td>${orderdetail.dishnumber}</td><td>${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	加菜<table>
	<tr>
	<td>菜品名</td><td>数量</td><td>价格</td>
	</tr>
	<c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==2 }">
			<tr>
			<td>${orderdetail.dishName}</td><td>${orderdetail.dishnumber}</td><td>${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	退菜<table>
	<tr>
	<td>菜品名</td><td>数量</td><td>价格</td>
	</tr>
	<c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==0 }">
			<tr>
			<td>${orderdetail.dishName}</td><td>${orderdetail.dishnumber}</td><td>${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	
	折扣<input type="text" name="discountamountPercent" onchange="CalculatingDiscount(this)">折
	<span id="discountamountValue"></span>元<br>
	<input type="hidden" name="discountamount"/>
	优惠券<input type="text" name="couponamount" onchange="changeAllprice()">元<br>
	总价：
	
	<span id="allprice">${order.price}</span>
	元	
	<input type="hidden" name="price" value="${order.price}">
	应付：
	<span id="showpayprice">${order.price}</span> <br>
	
	<input type="button" name="payment"  value="payment" onclick="pay('true')"/><br>
	<input type="button" name="writtenPermission" value="writtenPermission" onclick="pay('false')"/><br>
	<input type="button" name="cancel"  value="cancel" onclick="back()"/>
</form> --%>
<object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop.exe"></embed>
</object> 
</body>
<script type="text/javascript"  src="${pageContext.request.contextPath }/js/system/print/LodopFuncs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/checkout.js"></script>
</html>