<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始化订单</title>
</head>
<body>
订单信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/order/startorderSubmit.action" method="post">
	<input type="hidden" name="diningTableId" value="${diningTableId}"/> <br />
	<input type="hidden" name="createtime" value="${createtime }" /><br />
	桌号:${diningTableSeatnumber }<br />
	人数<input type="text" name="numberofpeople"/><br />
	服务员<input type="text" name="waiter" /><br />
	时间${createtime }<br />
	<input type="submit" value="submit"/>
</form>
</body>
</html>