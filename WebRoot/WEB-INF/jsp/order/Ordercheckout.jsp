<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/checkout.js"></script>
<title>结账界面</title>
</head>
<body>
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
			<td>${orderdetail.dishName}</td><td>${orderdetail.dishNumber}</td><td>${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	折扣<input type="text" name="discountamountPercent" onchange="CalculatingDiscount(this)">折
	<span id="discountamountValue"></span>元
	<input type="hidden" name="discountamount"/>
	优惠券<input type="text" name="couponamount" onchange="changeAllprice()">元
<%-- 	总价：
	
	<span id="allprice">${order.price}</span>
	元	 --%>
	<input type="hidden" name="price" value="${order.price}">
	应付：
	<span id="showpayprice">${order.price}</span>
	
	<input type="button" name="payment"  value="payment" onclick="pay('true')"/>
	<input type="button" name="writtenPermission" value="writtenPermission" onclick="pay('false')"/>
	<input type="button" name="cancel"  value="cancel" onclick="back()"/>
</form>
</body>
</html>