<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改账单界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/editordermessage.js"></script>
</head>
<body>
订单详情：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form id="editform" action="${pageContext.request.contextPath}/order/editorder.action" method="post">
	<input type="hidden" name="id" value="${order.id }">
	<input type="hidden" name="rDiningtableId" value="${order.rDiningtableId}"/>
	<input type="hidden" name="createtime" value="${endtime }" />
	<input type="hidden" name="numberofpeople" value="${order.numberofpeople }" />
	<input type="hidden" name="waiter" value="${order.waiter }" />
	桌号:${order.diningTableName }<br />
	服务员${order.waiter}<br />
	时间${endtime}<br />
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	正常菜
	<table>
	<tr>
	<td>菜品名</td><td>数量</td><td>单价</td><td>价格</td>
	</tr>
	<c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==1 }">
			<tr class="orderdish">
			<td class="dishname">${orderdetail.dishName}</td>
			<td class="dishnumber">${orderdetail.dishnumber}</td>
			<td class="price">
			<c:forEach items="${dishList}" var="dish">
				<c:if test="${dish.id==orderdetail.rdishid }">
					${dish.price}
				</c:if>
			</c:forEach></td>
			<td class="normaltotalprice">${orderdetail.price}</td>
			<td style="display:none">
				<input type="text"  class="dishid" value="${orderdetail.rdishid}">
			</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	加菜
	<input type="button" value="adddish" onclick="adddishofMessage('${pageContext.request.contextPath}')">
	<div id="alldish" style="display:none">
		<table>
			<tr>
				<td>菜品名</td><td>价格</td><td>操作</td>
			</tr>
		</table>
	</div>
	<table >
	<tr>
	<td>菜品名</td><td>数量</td><td>单价</td><td>总价</td><td>操作</td>
	</tr>
	<c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==2 }">
			<tr class="orderdish">
			<td class="dishname">${orderdetail.dishName}</td>
			<td class="dishnumber">${orderdetail.dishnumber}</td>
			<td class="price">
				<c:forEach items="${dishList}" var="dish">
					<c:if test="${dish.id==orderdetail.rdishid }">${dish.price}</c:if>
				</c:forEach>
			</td>
			<td class="addtotalprice">${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	退菜
	<input type="button" value="Retreatdish" onclick="RetreatdishofMessage(this)">
	<div id="orderdish" style="display:none">
		<table>
			<tr>
				<td>菜品名</td><td>价格</td><td>操作</td>
			</tr>
		</table>
	</div>
	
	<table>
	<tr>
	<td>菜品名</td><td>数量</td><td>单价</td><td>价格</td>
	</tr>
	<c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==0 }">
			<tr class="orderdish">
			<td class="dishname">${orderdetail.dishName}</td>
			<td class="dishnumber">${orderdetail.dishnumber}</td>
			<td class="price">
				<c:forEach items="${dishList}" var="dish">
					<c:if test="${dish.id==orderdetail.rdishid }">
						${dish.price}
					</c:if>
				</c:forEach>
			</td>
			<td class="reducetotalprice">${orderdetail.price}</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;" />
	总价：<span id="allprice">${order.price}</span>元	
	<input type="hidden" name="price" value="${order.price}" />
	<input type="button" name="ok"  value="ok" onclick="formsubmit()"/>
	<input type="button" name="cancel"  value="cancel" onclick="PageToUrl('${pageContext.request.contextPath}/order/getAllOrderofNotCheckout.action')"/>
</form>
</body>
</html>