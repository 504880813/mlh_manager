<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改分类</title>
</head>
<body>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改分类信息</strong></div>
   <div style="width:900px; margin:auto">
  <form action="${pageContext.request.contextPath}/category/${category.id ==null ? 'addCategorySubmit' : 'editCategorySubmit'}.action" method="post">
   	<input type="hidden" name="id" value="${category.id}" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >分类名</td>
       <td>
	       <input type="text" name="name" value="${category.name }" />
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









<%-- 分类信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/category/${category.id ==null ? 'addCategorySubmit' : 'editCategorySubmit'}.action" method="post">
	<input type="hidden" name="id" value="${category.id}" />
	分类名<input type="text" name="name" value="${category.name }" />
	<input type="submit" value="submit"/>
</form> --%>
</body>
</html>