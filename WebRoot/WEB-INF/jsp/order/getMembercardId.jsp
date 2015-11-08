<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取会员卡号</title>
</head>
<body>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<!-- 读卡器设置 start-->
<object classid="clsid:8B5A1D0B-4142-4EE1-B247-56DFD7C1CACA" id="obj_ie" width="0" height="0" align="left" ></object>
<embed id="obj_firefox_chrome" type="application/mozilla-npruntime-scriptable-plugin" width=0 height=0 ><br>
<!-- 读卡器设置 end-->
<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改会员卡信息</strong></div>
   <div style="width:900px; margin:auto">
  <form id="dataform" action="${pageContext.request.contextPath}/order/CheckoutofMemberid.action" method="post">
  	<input type="hidden" name="diningtableid" id="diningtableid" value="${diningtableid }">
   <table  class="table table-bordered">
     <tbody id="cardMessage">
     <tr>
       <td align="right" bgcolor="#f1f1f1" >读卡器接入状态</td>
       <td>
	       <span id="message">等待读卡器接入。。。</span>
	   </td>
     </tr>
       <tr>
       <td align="right" bgcolor="#f1f1f1" >卡号</td>
       <td>
	       <input type="text" id="cardid" name="cardid"/>
	   </td>
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
	
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/Card_reader_operation.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/order/getMembercardIdofSetUpCard.js"></script>
</body>
</html>