<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{
	    margin:0px;
	    padding:0px;
	    text-align:center; 
	    background:#e9fbff;
	    background-image: url("${pageContext.request.contextPath }/images/background.jpg");
	}
	#container{
	 /*    position:relative;
	    margin:0 auto;
	    padding:0px;
	    width:700px;
	    text-align:center; */
	    width:0;
	    height:0;
	    position:fixed;
	    left:50%;
	    rigth:50%;
	    top:50%;
	    bottom:50%;
	}
	#bindform{
		width:600px;
		height:220px;
		margin-left:-300px;
		margin-top:-110px;
	}
	#cardidText{
		background: white;
	}
</style>
<title>绑定清一色会员</title>
</head>
<body>
	<div id="container">
	<form id="bindform">
	<input type="hidden" id="openid" name="openid" value="${openid }"><br />
	<span id="cardidText">会员号</span>
	<input type="text" id="cardid" name="cardid"/>
	<br />
	<input type="button" id="submit_validation" value="绑定" />
	<input type="button" id="close" value="退出" />
	</form>
	
<%-- 	<div style="background-color:white;">
	${pageContext.request.contextPath }<br>
	${chenck.appid}<br>
	${chenck.timestamp}<br>
	${chenck.nonceStr}<br>
	${chenck.signature}<br>
	${openid }<br>
	</div> --%>
	</div>
</body>



<script type="text/javascript">
	var basepath="${pageContext.request.contextPath }";
	var appId="${chenck.appid}";
	var timestamp=${chenck.timestamp};
	var nonceStr="${chenck.nonceStr}";
	var signature="${chenck.signature}";
	var openid="${openid }";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/AccessTemlate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechat/ValidationMemberPage.js"></script>
</html>