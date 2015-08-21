<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改账单界面</title>
</head>
<body>
订单详情：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/order/CheckoutSubmit.action" method="post">
	<input type="hidden" name="diningTableId" value="${order.rDiningtableId}"/>
	<input type="hidden" name="createtime" value="${order.createtime }" />
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
	加菜
	<input type="button" value="adddish" onclick="">
	<div id="alldish" style="display:none">
		
		<input type="button" value="ok" onclick="">
	</div>
	<table>
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
	退菜
	<input type="button" value="Retreatdish" onclick="">
	<div id="orderdish" style="display:none">
		<input type="button" value="ok" onclick="">
	</div>
	<table>
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
	总价：<span id="allprice">${order.price}</span>元	
	<input type="button" name="ok"  value="ok" />
	<input type="button" name="cancel"  value="cancel" />
</form>
</body>
</html>