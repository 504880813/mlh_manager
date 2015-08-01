<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<h1>测试主页</h1>
<a href="${pageContext.request.contextPath }/diningTable/getAllDiningTableofManager.action">餐桌管理</a>
<a href="${pageContext.request.contextPath }/category/findAllcategory.action">分类管理</a>
<a href="${pageContext.request.contextPath }/materials/findAllmaterials.action">原料管理</a>
<a href="${pageContext.request.contextPath }/dish/findAllDish.action">菜品管理</a>

<a href="${pageContext.request.contextPath }/diningTable/getAllDiningTableoforder.action">订单流程</a>

<a href="${pageContext.request.contextPath }/order/">收银界面</a>
</body>
</html>