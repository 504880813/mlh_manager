<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改账单界面</title>

</head>
<body>


<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>修改订单信息</strong></div>
   <div style="width:900px; margin:auto">
 <form id="editform" action="${pageContext.request.contextPath}/order/editorder.action" method="post">
	<input type="hidden" name="id" value="${order.id }">
	<input type="hidden" name="rDiningtableId" value="${order.rDiningtableId}"/>
	<input type="hidden" name="createtime" value="${endtime }" />
	<input type="hidden" name="numberofpeople" value="${order.numberofpeople }" />
	<input type="hidden" name="waiter" value="${order.waiter }" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td width="10%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" >桌号</td>
       <td width="23%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" >
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
     	<td width="100%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="6">初点菜</td>
     </tr>
     <tr>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">菜品名</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >数量</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >单价</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >总价</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >操作</td>
     </tr>
     <c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==1 }">
			<tr class="orderdish">
			<td class="dishname" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishName}</td>
			<td class="dishnumber" nowrap="nowrap" align="right" bgcolor="#f1f1f1">${orderdetail.dishnumber}</td>
			<td class="price" nowrap="nowrap" align="right" bgcolor="#f1f1f1">
			<c:forEach items="${dishList}" var="dish">
				<c:if test="${dish.name == orderdetail.rdishname }">
					${dish.price}
				</c:if>
			</c:forEach>
			</td>
			<td class="normaltotalprice" nowrap="nowrap" align="right" bgcolor="#f1f1f1">${orderdetail.price}</td>
			<td style="display:none" nowrap="nowrap" align="right" bgcolor="#f1f1f1">
				<input type="text"  class="dishid" value="${orderdetail.rdishname}">
			</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1">
			
			<input value="加" name="add" class="btn btn-info" style="width:80px;" type="button" onclick="adddish('initial',this)">
			<input value="退" name="retreat" class="btn btn-info" style="width:80px;" type="button" onclick="retreatdish('initial',this)">
			
			</td>
			</tr>
		</c:if>
	</c:forEach>
	 <tr>
     	<td width="100%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="6">
     	加菜栏
  <%--    	<input type="button" value="adddish" onclick="adddishofMessage('${pageContext.request.contextPath}')">
     	<div id="alldish" style="display:none">
		<table>
			<tr>
				<td>菜品名</td><td>价格</td><td>操作</td>
			</tr>
		</table>
		</div> --%>
     	</td>
     </tr>
     <tr>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">菜品名</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >数量</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >单价</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >总价</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >操作</td>
     </tr>
     
     	<c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==2 }">
			<tr class="orderdish">
			<td class="dishname"  nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishName}</td>
			<td class="dishnumber"  nowrap="nowrap" align="right" bgcolor="#f1f1f1">${orderdetail.dishnumber}</td>
			<td class="price"  nowrap="nowrap" align="right" bgcolor="#f1f1f1">
				<c:forEach items="${dishList}" var="dish">
					<c:if test="${dish.name == orderdetail.rdishname }">${dish.price}</c:if>
				</c:forEach>
			</td>
			<td class="addtotalprice"  nowrap="nowrap" align="right" bgcolor="#f1f1f1">${orderdetail.price}</td>
			<td nowrap="nowrap" align="right" bgcolor="#f1f1f1">
			
			<input value="+1" name="add" class="btn btn-info" style="width:80px;" type="button" onclick="adddish('add',this)">
			<input value="-1" name="retreat" class="btn btn-info" style="width:80px;" type="button" onclick="retreatdish('add',this)">
			
			</td>
			</tr>
		</c:if>
		</c:forEach>
	  <tr id="adddishtr"></tr>
      <tr>
     	<td width="100%" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="6">
     		退菜栏
     		<!-- <input type="button" value="Retreatdish" onclick="RetreatdishofMessage(this)">
				<div id="orderdish" style="display:none">
					<table>
						<tr>
							<td>菜品名</td><td>价格</td><td>操作</td>
						</tr>
					</table>
				</div> -->
     	</td>
     </tr>
     <tr>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">菜品名</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >数量</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >单价</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >总价</td>
     	<td nowrap="nowrap" align="right" bgcolor="#f1f1f1" >操作</td>
     </tr>
     <c:forEach items="${order.orderdetailList }" var="orderdetail">
		<c:if test="${orderdetail.echelon==0 }">
			<tr class="orderdish">
			<td class="dishname" nowrap="nowrap" align="right" bgcolor="#f1f1f1" colspan="2">${orderdetail.dishName}</td>
			<td class="dishnumber" nowrap="nowrap" align="right" bgcolor="#f1f1f1">${orderdetail.dishnumber}</td>
			<td class="price" nowrap="nowrap" align="right" bgcolor="#f1f1f1">
				<c:forEach items="${dishList}" var="dish">
					<c:if test="${dish.name == orderdetail.rdishname }">
						${dish.price}
					</c:if>
				</c:forEach>
			</td>
			<td class="reducetotalprice" nowrap="nowrap" align="right" bgcolor="#f1f1f1">${orderdetail.price}</td>
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
     
   	</tbody>
   </table>
   
      <!-- 分类start -->
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
			<c:forEach items="${dishList }" var="dish">
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
    
    <!-- 分类end -->
   
   
   
   
   
   
   <table class="margin-bottom-20 table  no-border">
        <tbody><tr>
     	<td class="text-center">
     	<input value="确定" name="ok" class="btn btn-info" style="width:80px;" type="button" onclick="formsubmit()">
     	</td>
     	<td class="text-center">
     	<input value="返回" name="cancel" class="btn btn-info" style="width:80px;" type="button" onclick="PageToUrl('${pageContext.request.contextPath}/order/getAllOrderofNotCheckout.action')">
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
				<c:if test="${dish.id==orderdetail.rdishname }">
					${dish.price}
				</c:if>
			</c:forEach></td>
			<td class="normaltotalprice">${orderdetail.price}</td>
			<td style="display:none">
				<input type="text"  class="dishid" value="${orderdetail.rdishname}">
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
					<c:if test="${dish.id==orderdetail.rdishname }">${dish.price}</c:if>
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
					<c:if test="${dish.id==orderdetail.rdishname }">
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
</form> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/editordermessage.js"></script>
</html>