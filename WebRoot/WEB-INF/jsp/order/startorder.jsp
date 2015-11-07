<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始化订单</title>
</head>
<body>


<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>

<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>初始化订单</strong></div>
   <div style="width:900px; margin:auto">
<form action="${pageContext.request.contextPath}/order/startorderSubmit.action" method="post">
	<input type="hidden" name="diningTableId" value="${diningTableId}"/>
	<input type="hidden" name="createtime" value="${createtime }" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >桌号</td>
       <td>
	       <input type="text" name="name" value="${diningTableSeatnumber }" />
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >人数</td>
       <td>
	       <input type="text" name="numberofpeople"/>
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >服务员</td>
       <td>
	      	<input type="text" name="waiter" />
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >时间</td>
       <td>
	       ${createtime }
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





<%-- 订单信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/order/startorderSubmit.action" method="post">
	<input type="hidden" name="diningTableId" value="${diningTableId}"/> <br />
	<input type="hidden" name="createtime" value="${createtime }" /><br />
	桌号:${diningTableSeatnumber }<br />
	人数<input type="text" name="numberofpeople"/><br />
	服务员<input type="text" name="waiter" /><br />
	时间${createtime }<br />
	<input type="submit" value="submit"/>
</form> --%>
</body>
</html>