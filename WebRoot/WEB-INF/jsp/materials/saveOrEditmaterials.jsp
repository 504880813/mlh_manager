<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改原料</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改分类信息</strong></div>
   <div style="width:900px; margin:auto">
  <form action="${pageContext.request.contextPath}/materials/${materials.id ==null ? 'addmaterialsSubmit' : 'editmaterialsSubmit'}.action" method="post">
   	<input type="hidden" name="id" value="${materials.id}" />
   <table  class="table table-bordered">
     <tbody>
     
	<%-- <input type="text" name="surplus" value="${materials.surplus}" /> --%>
	
     <tr>
       <td align="right" bgcolor="#f1f1f1" >原料名</td>
       <td>
	      <input type="text" name="name" value="${materials.name }" />
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >库存</td>
       <td>
	      <input type="text" name="surplus" value="${materials.surplus}" /> 
	   </td>
     </tr>
       <tr>
       <td align="right" bgcolor="#f1f1f1" >库存单位</td>
       <td>
	      <input type="text" name="unit" value="g">
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

















<%-- 原料信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/materials/${materials.id ==null ? 'addmaterialsSubmit' : 'editmaterialsSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${materials.id}" />
	原料名<input type="text" name="name" value="${materials.name }" />
	库存<input type="text" name="surplus" value="${materials.surplus}" />
	库存单位<input type="text" name="unit" value="g">
	<input type="submit" value="submit"/>
</form> --%>
</body>
</html>