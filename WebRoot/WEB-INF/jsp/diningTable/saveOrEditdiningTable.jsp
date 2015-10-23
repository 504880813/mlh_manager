<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改餐桌</title>
</head>
<body>
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
餐桌信息：
<br />
<form action="${pageContext.request.contextPath}/diningTable/${diningTable.id ==null ? 'addDiningTableSubmit' : 'editDiningTableSubmit'}.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${diningTable.id}" />
	餐桌号<input type="text" name="seatnumber" value="${diningTable.seatnumber}" > <br />
	<c:if test="${customdiningTableImage==null}">
		 餐桌空闲时图片:<input type="file" name="freeimageFile" />
		餐桌繁忙时图片:<input type="file" name="busyimageFile" />
	</c:if>
	<c:if test="${customdiningTableImage!=null}">
		 <input type="hidden" name="freeimage" value="${customdiningTableImage.freeimage}" />
		<input type="hidden" name="busyimage" value="${customdiningTableImage.busyimage}" />
	</c:if>
	<input type="submit" value="submit"/>
</form>
</body>
</html>