<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改会员卡号</title>
</head>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<!-- 读卡器设置 start-->
<object classid="clsid:8B5A1D0B-4142-4EE1-B247-56DFD7C1CACA" id="obj_ie" width="0" height="0" align="left" ></object>
<embed id="obj_firefox_chrome" type="application/mozilla-npruntime-scriptable-plugin" width=0 height=0 ><br>
<!-- 读卡器设置 end-->

<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><strong>补办会员卡</strong></div>
   <div style="width:900px; margin:auto">
<form id="dataform" action="${pageContext.request.contextPath}/card/ReapplyCardSubMit.action" method="post">
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >读卡器状态</td>
       <td>
	       <span id="message">等待读卡器接入。。。</span><br>
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >旧卡号</td>
       <td>
	       <input type="text" id="oldcardid" name="oldcardid" readonly="readonly" value="${oldcardid }"/>
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >新卡号</td>
       <td>
	       <input type="text" id="newcardid" name="newcardid">
	   </td>
     </tr>
      <random:hasRight uri="ValidationCode">
      	<tr>
	       <td align="right" bgcolor="#f1f1f1" >请输入验证码(顾客的微信收到的)</td>
	       <td>
		       <input type="text" name="PagevalidationCode">
		   </td>
     	</tr>
     </random:hasRight>
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

<%@ include file="/JspbaseTemplate/footer.jsp" %> 

<%-- <form action="${pageContext.request.contextPath}/card/ReapplyCardSubMit.action" method="post">
	<span id="message">等待读卡器接入。。。</span><br>
	旧卡号<input type="text" name="oldcardid" readonly="readonly" value="${oldcardid }"/>
	新卡号<input type="text" name="newcardid">
	<random:hasRight uri="ValidationCode">
		请输入验证码(顾客的微信收到的)
	<input type="text" name="PagevalidationCode">
	</random:hasRight>
	<input type="submit" value="submit"/>
</form> --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/Card_reader_operation.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/ReapplyCard.js"></script>
</body>
</html>