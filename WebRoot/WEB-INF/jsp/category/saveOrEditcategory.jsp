<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改分类</title>
</head>
<body>
分类信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/category/${category.id ==null ? 'addCategorySubmit' : 'editCategorySubmit'}.action" method="post">
	<input type="hidden" name="id" value="${category.id}" />
	分类名<input type="text" name="name" value="${category.name }" />
	<input type="submit" value="submit"/>
</form>
</body>
</html>