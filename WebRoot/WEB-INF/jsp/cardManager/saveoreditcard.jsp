<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改会员卡信息</title>
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
  <form action="${pageContext.request.contextPath}/card/${card.id ==null ? 'addcardSubmit' : 'editcardSubmit'}.action" method="post">
   	<input type="hidden" name="id" value="${card.id}" />
	<input type="hidden" name="isavailable" value="${card.isavailable}" />
	<input type="hidden" name="wechatOpenid" value="${card.wechatOpenid}" />
	<input type="hidden" name="allIntegral" value="${card.allIntegral}" />
	<input type="hidden" name="monthIntegral" value="${card.monthIntegral}" />
	<span style="display:none" id="levelSpan">
		<c:forEach items="${levels }" var="level" varStatus="status">
			<c:if test="${!status.last}">
				${level.cardlevel },
			</c:if>
			<c:if test="${status.last}">
				${level.cardlevel }
			</c:if>
		</c:forEach>
	</span>
   <table  class="table table-bordered">
     <tbody id="cardMessage">
     <tr>
       <td align="right" bgcolor="#f1f1f1" >会员卡类型：</td>
       <td>
	       <input type="radio" onclick="showInputdiv('true','${card.cardid }','${card.belongsCardid}','${card.username}','${card.phone}','${card.money}','${card.level }','${card.id!=null}')"/>主卡 
		   <input type="radio" onclick="showInputdiv('false','${card.cardid }','${card.belongsCardid}','${card.username}','${card.phone}','${card.money}','${card.level }','${card.id!=null}')"/>副卡 
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


<%-- 会员卡信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br /> --%>
</body>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/system/jquery-1.4.4.min.js"></script> --%>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/Card_reader_operation.js"></script> 

<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/saveoreditofsetUpCard.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/saveoredit.js"></script>

</html>