<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缴费页面</title>
</head>
<body>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>

<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><strong>缴费页面</strong></div>
   <div style="width:900px; margin:auto">
<form id="paypageForm" action="${pageContext.request.contextPath}/card/PayPageSubMit.action" method="post">
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >卡号</td>
       <td>
	      <input type="text" id="cardId" name="cardId" value="${card.cardid }"/>
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >折扣</td>
       <td>
	      <span id="nowDiscount">${cardLevel.discount }</span>
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >消费金额</td>
       <td>
	      <input type="text" id="Nowexpense" name="Nowexpense" onchange="CalculatingDiscount()"/><br/>
	   </td>
     </tr>
      <tr>
	       <td align="right" bgcolor="#f1f1f1" >折后金额</td>
	       <td>
		       <input type="text" id="expense" name="expense" readonly="readonly"/><br/>
		   </td>
      </tr>
       <tr>
	       <td align="right" bgcolor="#f1f1f1" >会员卡余额</td>
	       <td>
		      <span id="cardMoney">${card.money }</span><br/>
				应付款现金<span id="otherMoney">0元</span><br/>
		   </td>
      </tr>
       <tr>
	       <td align="right" bgcolor="#f1f1f1" >应付款现金</td>
	       <td>
				<span id="otherMoney">0元</span><br/>
		   </td>
      </tr>
   	</tbody>
   </table>
   <table class="margin-bottom-20 table  no-border">
        <tbody><tr>
     	<td class="text-center"><input value="确定" class="btn btn-info submit" style="width:80px;" type="button"  onclick="submitPage(this)"></td>
     </tr>
 	</tbody>
  </table>
 	<!-- <div id="cardMessage"></div> -->
   </form>   
   </div> 
  </div>     
</div>

<%@ include file="/JspbaseTemplate/footer.jsp" %> 








<%-- <form id="paypageForm" action="${pageContext.request.contextPath}/card/PayPageSubMit.action" method="post">
	卡号<input type="text" name="cardId" value="${card.cardid }"/><br/>
	折扣<span id="nowDiscount">${cardLevel.discount }</span>
	消费金额<input type="text" name="Nowexpense" onchange="CalculatingDiscount()"/><br/>
	折后金额<input type="text" name="expense" readonly="readonly"/><br/>
	会员卡余额<span id="cardMoney">${card.money }</span><br/>
	应付款现金<span id="otherMoney">0元</span><br/>
	<input type="button" value="submit" onclick="submitPage(this)"/>
</form> --%>




</body>

<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jDialog/jDialog.css" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/jDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.drag.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.mask.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jDialog/jquery.dialog.js" ></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/PayPage.js"></script>
</html>