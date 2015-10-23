<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<h1>测试主页</h1>
<%-- <jsp:include page="/JspbaseTemplate/header.jsp"></jsp:include> --%>
<random:Right_A uri="${pageContext.request.contextPath }/diningTable/getAllDiningTableofManager.action">餐桌管理</random:Right_A>
<random:Right_A uri="${pageContext.request.contextPath }/category/findAllcategory.action">分类管理</random:Right_A>
<%-- <random:Right_A uri="${pageContext.request.contextPath }/category/findAllcategory.action">分类管理</random:Right_A> --%>
<random:Right_A uri="${pageContext.request.contextPath }/materials/findAllmaterials.action">原料管理</random:Right_A>
<random:Right_A uri="${pageContext.request.contextPath }/dish/findAllDish.action">菜品管理</random:Right_A>

<random:Right_A uri="${pageContext.request.contextPath }/diningTable/getAllDiningTableoforder.action">订单流程</random:Right_A>

<random:Right_A uri="${pageContext.request.contextPath }/order/getAllOrderofNotCheckout.action">收银界面</random:Right_A>

<random:Right_A uri="${pageContext.request.contextPath }/card/getAllcard.action">会员卡相关</random:Right_A>
<br/>
<hr>
权限控制相关 :<br>
<random:Right_A uri="${pageContext.request.contextPath }/right/getAllRightofManager.action">权限管理</random:Right_A>
<random:Right_A uri="${pageContext.request.contextPath }/role/getAllRoleofManager.action">角色管理</random:Right_A>
<random:Right_A uri="${pageContext.request.contextPath }/user/getAllUserofManager.action">用户管理</random:Right_A>
<hr>
微信相关 :<br>
<random:Right_A uri="${pageContext.request.contextPath }/wechatuser/getAllUser.action">微信公众号管理</random:Right_A>

<random:Right_A uri="${pageContext.request.contextPath }/wechatTemplate/getAllTemplate.action">微信消息模板管理</random:Right_A>
<random:Right_A uri="${pageContext.request.contextPath }/wechatInterface/getAllInterface.action">微信接口url管理</random:Right_A>

<%-- <form action="${pageContext.request.contextPath }/wechat/MessageReceiver.action" method="post">
	<input type="submit" value="submit" />
</form> --%>
</body>
</html>