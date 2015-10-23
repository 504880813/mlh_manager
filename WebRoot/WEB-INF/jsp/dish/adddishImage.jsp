<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品图片</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dish/saveoredit.js"></script>
</head>
<body>
为${dish.name}添加图片
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/dish/addDishImageSubmit.action" method="post" enctype="multipart/form-data">
	请添加图片:
	<input type="hidden" name="dishid" value="${dish.id }">
	<div id="images">
		<input type="button" value="addImages" onclick="CloneNodeByid('dishImages','images')">
		<input type="button" value="removeImages" onclick="removeNodeByid('dishImages')"><br/>
		<input type="file" name="dishImages" id="dishImages"><br>
	</div>
	<input type="submit" value="submit"/>
</form>
</body>
</html>