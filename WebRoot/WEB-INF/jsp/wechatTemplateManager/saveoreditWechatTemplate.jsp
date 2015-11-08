<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改消息模板</title>
</head>
<body>



<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改消息模板信息</strong></div>
   <div style="width:900px; margin:auto">
<form id="wechatTemplateForm" action="${pageContext.request.contextPath}/wechatTemplate/${wechatTemplate.id ==null ? 'addwechatTemplateSubmit' : 'editwechatTemplateSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${wechatTemplate.id}" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
	
	
	
       <td align="right" bgcolor="#f1f1f1" >模板名称</td>
       <td>
	      <input type="text" name="name" id="name" value="${wechatTemplate.name }" />
	   </td>
     </tr>
        <tr>
       <td align="right" bgcolor="#f1f1f1" >模板id</td>
       <td>
	       <input type="text" name="templateId" id="templateId" value="${wechatTemplate.templateId}" />
	   </td>
     </tr>
        <tr>
       <td align="right" bgcolor="#f1f1f1" >点击模板后的响应链接</td>
       <td>
	       <input type="text" name="url" value="${wechatTemplate.url}" />
	   </td>
     </tr>
        <tr>
       <td align="right" bgcolor="#f1f1f1" >模板颜色</td>
       <td>
	       <input type="text" name="topcolor" id="topcolor" value="${wechatTemplate.topcolor}" />
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











<%-- 消息模板信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/wechatTemplate/${wechatTemplate.id ==null ? 'addwechatTemplateSubmit' : 'editwechatTemplateSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${wechatTemplate.id}" />
	模板名称<input type="text" name="name" value="${wechatTemplate.name }" />
	模板id<input type="text" name="templateId" value="${wechatTemplate.templateId}" />
	点击模板后的响应链接<input type="text" name="url" value="${wechatTemplate.url}" />
	模板颜色<input type="text" name="topcolor" value="${wechatTemplate.topcolor}" />
	<input type="submit" value="submit"/>
</form> --%>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/wechatTemplateManager/saveoreditWechatTemplate.js"></script>
</html>