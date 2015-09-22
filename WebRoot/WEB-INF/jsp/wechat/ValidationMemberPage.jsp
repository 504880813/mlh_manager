<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>绑定清一色会员</title>
</head>
<body>

	<form id="bindform">
	<input type="hidden" id="openid" name="openid" value="${openid }"><br />
	会员号<input type="text" id="cardid" name="cardid"/>
	<br />
	<input type="button" id="submit_validation" value="绑定" />
	<input type="button" id="close" value="退出" />
	</form>
</body>



<script type="text/javascript">
	var basepath="${pageContext.request.contextPath }";
	var appId="${chenck.appid}";
	var timestamp=${chenck.timestamp};
	var nonceStr="${chenck.nonceStr}";
	var signature="${chenck.signature}";
	var openid="${openid }";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/AccessTemlate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/ValidationMemberPage.js"></script>
</html>