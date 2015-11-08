<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值会员卡</title>
</head>
<body>
<%-- 充值信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br /> --%>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>会员卡充值</strong></div>
   <div style="width:900px; margin:auto">
<form id="RechargeForm" action="${pageContext.request.contextPath}/card/RechargecardSubMit.action" method="post">
   <input type="hidden" name="id" value="${card.id}" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >卡号</td>
       <td>
	       ${card.cardid }
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >用户名</td>
       <td>
	       ${card.username}
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >电话</td>
       <td>
	       ${card.phone}
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >充值金额</td>
       <td>
	       <input type="text" id="RechargeMoney" name="RechargeMoney"/>元
	   </td>
     </tr>
   	</tbody>
   </table>
   <table class="margin-bottom-20 table  no-border">
        <tbody><tr>
     	<td class="text-center"><input value="确定" class="btn btn-info submit" style="width:80px;" type="submit"></td>
     </tr>
 	</tbody>
  </table>
 	<!-- <div id="cardMessage"></div> -->
   </form>   
   </div> 
  </div>     
</div>
<%-- <form action="${pageContext.request.contextPath}/card/RechargecardSubMit.action" method="post">
	<input type="hidden" name="id" value="${card.id}" />
	卡号<span>${card.cardid }</span><br>
	用户名<span>${card.username}</span><br>
	电话<span>${card.phone}</span><br>
	充值金额<input type="text" name="RechargeMoney"/>
	<input type="submit" value="submit"/>
</form> --%>

<%@ include file="/JspbaseTemplate/footer.jsp" %> 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/Rechargecard.js"></script>
</body>
</html>