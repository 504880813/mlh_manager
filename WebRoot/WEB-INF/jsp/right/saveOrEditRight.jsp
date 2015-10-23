<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改权限</title>
</head>
<body>
权限信息：
<br />
<form action="${pageContext.request.contextPath}/right/${right.id ==null ? 'addrightSubmit' : 'editrightSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${right.id}" />
	权限名称<input type="text" name="name" value="${right.name}" > <br />
	权限url<input type="text" name="url" value="${right.url}" > <br />
	权限描述<input type="text" name="description" value="${right.description}" > <br />
	权限码<input type="text" name="code" value="${right.code}" > <br />
	权限位<input type="text" name="pos" value="${right.pos}" > <br />
	<c:if test="${right.id ==null}">
		公共资源<br>
		是<input id="common" name="common" type="radio" value="true"/> 
		不是<input id="common" name="common" type="radio" value="false"/> 
	</c:if>
	<c:if test="${right.id !=null}">
		<c:if test="${right.common}">
			公共资源<br>
			是<input id="common" name="common" type="radio" value="true" checked/> 
			不是<input id="common" name="common" type="radio" value="false"/> 
		</c:if>
		<c:if test="${!right.common}">
			公共资源<br>
			是<input id="common" name="common" type="radio" value="true" /> 
			不是<input id="common" name="common" type="radio" value="false" checked/> 
		</c:if>
	</c:if>
	<input type="submit" value="submit"/>
</form>
</body>
</html>