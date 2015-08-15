<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改原料</title>
</head>
<body>
原料信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/materials/${materials.id ==null ? 'addmaterialsSubmit' : 'editmaterialsSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${materials.id}" />
	原料名<input type="text" name="name" value="${materials.name }" />
	库存<input type="text" name="surplus" value="${materials.surplus}" />
	库存单位<input type="text" name="unit" value="${materials.unit }">
	<input type="submit" value="submit"/>
</form>
</body>
</html>