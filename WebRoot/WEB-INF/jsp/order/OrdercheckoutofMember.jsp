<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.ico" type="image/x-icon" />
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
<form action="${pageContext.request.contextPath}/order/MemberCheckout.action" method="post">
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
	
	折扣<input type="text" name="discountamountPercent" readonly="readonly" value="${cardLevel.discount }">折
	<span id="discountamountValue">
		<fmt:formatNumber value="${order.price-order.price*cardLevel.discount*0.1}" pattern="#,###.##" />
	</span>元<br>
	<input type="hidden" name="discountamount" value="${order.price-order.price*cardLevel.discount*0.1}"/>
	优惠券<input type="text" name="couponamount" onchange="changeAllprice()">元<br>
<%-- 	总价：
	
	<span id="allprice">${order.price}</span>
	元	 --%>
	
	应付：
	<span id="showpayprice"><fmt:formatNumber value="${order.price*cardLevel.discount*0.1}" pattern="#,###.##" /></span> <br>
	会员卡余额<span id="cardMoney">${card.money }</span><br/>
	<span id="otherMoney" style="display:none"></span><br/>
	
	<input type="hidden" name="price" value="<fmt:formatNumber value="${order.price*cardLevel.discount*0.1}" pattern="#,###.##" />">
	<input type="hidden" name="expense" value="<fmt:formatNumber value="${order.price*cardLevel.discount*0.1}" pattern="#,###.##" />"/>
	<input type="hidden" name="cardId" value="${card.cardid }"/>
	
	<input type="button" name="payment"  value="payment" onclick="pay('true')"/><br>
	<input type="button" name="writtenPermission" value="writtenPermission" onclick="pay('false')"/><br>
	<input type="button" name="cancel"  value="cancel" onclick="back()"/>
</form>
</body>
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jDialog/jDialog.css" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.drag.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.mask.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.dialog.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/Membercheckout.js"></script>
</html>