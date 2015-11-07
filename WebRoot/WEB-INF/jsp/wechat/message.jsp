<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全局消息页面</title>
</head>
<body>
${message}
<input type="button" id="close" value="退出" />
</body>
<script type="text/javascript">
	var appId="${chenck.appid}";
	var timestamp=${chenck.timestamp};
	var nonceStr="${chenck.nonceStr}";
	var signature="${chenck.signature}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/AccessTemlate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/message.js"></script>
</html>