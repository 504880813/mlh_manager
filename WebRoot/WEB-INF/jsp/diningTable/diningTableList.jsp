<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>餐桌列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/diningTable/addDiningTable.action">添加餐桌</a><br />
<a href="${pageContext.request.contextPath }/diningTable/changeImage.action">改变桌面背景</a><br />
餐桌列表：
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
	<a href="${pageContext.request.contextPath }/diningTable/editDiningTable.action?id=${diningTable.id}">修改</a>
	<a href="${pageContext.request.contextPath }/diningTable/deleteDiningTable.action?id=${diningTable.id}">删除</a>
	<%-- <a href="${pageContext.request.contextPath }/diningTable/changeDiningTableState.action?id=${diningTable.id}&&currtstate=${diningTable.isfree}">改变状态</a> --%>
	<%-- <c:if test="${diningTable.isfree }">
	<a href="${pageContext.request.contextPath }/order/startOrder.action?diningTableId=${diningTable.id}&&diningTableSeatnumber=${diningTable.seatnumber}">开台</a>
	</c:if> --%>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>