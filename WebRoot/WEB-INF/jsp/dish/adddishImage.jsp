<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品图片</title>
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
	暂时一个图片:
	<input type="hidden" name="dishid" value="${dish.id }">
	<input type="file" name="dishImages" id="dishImages">
	<input type="submit" value="submit"/>
</form>
</body>
</html>