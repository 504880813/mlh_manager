<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据会员电话号码获取会员卡号</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>根据会员电话号码获取会员卡号</strong></div>
   <div style="width:900px; margin:auto">
<form action="${pageContext.request.contextPath}/order/CheckoutofphoneAndcardid.action" method="post">
	<input type="hidden" name="diningtableid" value="${diningtableid}">
	<input type="hidden" name="cardid" />
	
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >电话号码</td>
       <td>
	       <input type="text" name="phoneNumber"/>
		   <input type="button" value="确认电话" onclick="selectcardByphoneNumber('${pageContext.request.contextPath}')">
	   		<div id="cardDiv"></div>
	   </td>
     </tr>
     <tr>
     	 <div id="validationCodeDiv" style="display:none">
		<random:hasRight uri="ValidationCode">
				<td align="right" bgcolor="#f1f1f1">请输入验证码(顾客的微信收到的)</td>
				<td><input type="text" name="PageValidationCode"></td>
		</random:hasRight>
		</div>	
     </tr>
   	</tbody>
   </table>
   <table class="margin-bottom-20 table  no-border">
        <tbody><tr>
     	<td class="text-center"><input value="确定" class="btn btn-info " style="width:80px;" type="submit"></td>
     </tr>
 	</tbody>
  </table>
 	<!-- <div id="cardMessage"></div> -->
   </form>   
   </div> 
  </div>     
</div>

<%@ include file="/JspbaseTemplate/footer.jsp" %> 






<%-- <form action="${pageContext.request.contextPath}/order/CheckoutofphoneAndcardid.action" method="post">
	<input type="hidden" name="diningtableid" value="${diningtableid}">
	<input type="hidden" name="cardid" />
	
	电话号码<input type="text" name="phoneNumber"/>
	<input type="button" value="确认电话" onclick="selectcardByphoneNumber('${pageContext.request.contextPath}')">
	
	<div id="cardDiv"></div>
	
	<div id="validationCodeDiv" style="display:none">
		<random:hasRight uri="ValidationCode">
				请输入验证码(顾客的微信收到的)
				<input type="text" name="PageValidationCode">
		</random:hasRight>
		<br/><input type="submit" value="submit"/>
	</div>	


		
	
</form> --%>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/getMembercardIdofPhone.js"></script>
</body>

</html>