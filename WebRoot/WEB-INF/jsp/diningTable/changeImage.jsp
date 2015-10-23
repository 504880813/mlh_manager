<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改餐桌图片</title>
</head>
<body>
餐桌信息：
<br />
<form action="${pageContext.request.contextPath}/diningTable/changeImageSubmit.action" method="post" enctype="multipart/form-data">
		 餐桌空闲时图片:<input type="file" name="freeimageFile" />
		餐桌繁忙时图片:<input type="file" name="busyimageFile" />
		<input type="submit" value="submit">
</form>
</body>
</html>