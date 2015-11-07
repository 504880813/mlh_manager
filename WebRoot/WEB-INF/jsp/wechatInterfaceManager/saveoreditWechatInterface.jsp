<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改本地微信接口</title>
</head>
<body>


<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改本地微信接口信息</strong></div>
   <div style="width:900px; margin:auto">
 <form action="${pageContext.request.contextPath}/wechatInterface/${wechatInterface.id ==null ? 'addwechatInterfaceSubmit' : 'editwechatInterfaceSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${wechatInterface.id}" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >微信接口调用名称</td>
       <td>
	      <input type="text" name="name" value="${wechatInterface.name }" />
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >微信接口调用url</td>
       <td>
	       <input type="text" name="url" value="${wechatInterface.url}" />
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >微信接口描述</td>
       <td>
	       <input type="text" name="description" value="${wechatInterface.description}" />
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






<%-- 本地微信接口信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/wechatInterface/${wechatInterface.id ==null ? 'addwechatInterfaceSubmit' : 'editwechatInterfaceSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${wechatInterface.id}" />
	微信接口调用名称<input type="text" name="name" value="${wechatInterface.name }" />
	微信接口调用url<input type="text" name="url" value="${wechatInterface.url}" />
	微信接口描述<input type="text" name="description" value="${wechatInterface.description}" />
	<input type="submit" value="submit"/>
</form> --%>
</body>
</html>