<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡列表</title>
</head>
<body>
<random:Right_A uri="${pageContext.request.contextPath }/card/addcard.action">添加会员卡</random:Right_A><br />
<random:Right_A uri="${pageContext.request.contextPath }/card/getAllcardLevel.action">会员卡等级信息</random:Right_A><br />
<random:Right_A uri="${pageContext.request.contextPath }/card/getMemberCardId.action">会员卡缴费</random:Right_A><br />

<form action="${pageContext.request.contextPath }/card/selectAllRecordsBycardid.action" method="post">
<input type="text" name="cardid" /><br/>
<input type="submit" value="查询" />
</form>
会员卡列表：
<table width="100%" border=1>
<tr>
	<td>卡号</td>
	<td>主卡号</td>
	<td>会员卡等级</td>
	<td>用户名</td>
	<td>电话号码</td>
	<td>微信是否关联</td>
	<td>使用状态</td>
	<td>余额</td>
	<td>总积分</td>
	<td>当月积分</td>
	<td>操作</td>
</tr>
<c:forEach items="${cards}" var="card">
<tr>	
	<td>${card.cardid}</td>
	<td>${card.belongsCardid==null?'是主卡':card.belongsCardid}</td>
	<td>${card.level=='-1'?'副卡':card.level}</td>
	<td>${card.username}</td>
	<td>${card.phone}</td>
	<td>${card.wechatOpenid==null||card.wechatOpenid==""?'没关联':'关联'}</td>
	<td>${card.isavailable==true?'正常使用':'冻结'}</td>
	<td>${card.money}</td>
	<td>${card.allIntegral}</td>
	<td>${card.monthIntegral}</td>
	<td>
	<random:Right_A uri="${pageContext.request.contextPath }/card/editcard.action?id=${card.id}">修改基础信息</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/card/deletecard.action?id=${card.id}">删除</random:Right_A>
	<c:if test="${card.wechatOpenid!=null&&card.wechatOpenid!=''}">
	<random:Right_A uri="${pageContext.request.contextPath }/card/getAllTemplateTosend.action?useropenid=${card.wechatOpenid}">发送模板消息</random:Right_A>
	</c:if>
	<random:Right_A uri="${pageContext.request.contextPath }/card/changecardstatus.action?id=${card.id}&isavailable=${card.isavailable}">冻结/激活</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/card/Rechargecard.action?id=${card.id}">充值</random:Right_A>
	<random:Right_A uri="${pageContext.request.contextPath }/card/ReapplyCard.action?id=${card.id }">补办会员卡</random:Right_A>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>