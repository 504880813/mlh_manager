<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改会员卡等级信息</title>
</head>
<body>
会员卡等级信息:
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/card/${cardLevel.id ==null ? 'addcardLevelSubmit' : 'editcardLevelSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${cardLevel.id}" />
	会员卡等级名称<input type="text" name="cardlevel" value="${cardLevel.cardlevel}" /><br/>
	会员卡等级折扣<input type="text" name="discount" value="${cardLevel.discount}" />折
	<input type="submit" value="submit"/>
</form>
</body>
</html>