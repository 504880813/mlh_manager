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

<a href="${pageContext.request.contextPath }/order/getAllOrderofNotCheckout.action">收银界面</a>

<a href="${pageContext.request.contextPath }/card/getAllcard.action">会员卡相关</a>
<br/>
<hr>
微信相关 :<br>
<a href="${pageContext.request.contextPath }/wechatuser/getAllUser.action">微信公众号管理</a>

<a href="${pageContext.request.contextPath }/wechatTemplate/getAllTemplate.action">微信消息模板管理</a>
<a href="${pageContext.request.contextPath }/wechatInterface/getAllInterface.action">微信接口url管理</a>

<%-- <form action="${pageContext.request.contextPath }/wechat/MessageReceiver.action" method="post">
	<input type="submit" value="submit" />
</form> --%>
</body>
</html>