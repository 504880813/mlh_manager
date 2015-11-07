<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品图片</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>为${dish.name}添加图片</strong></div>
   <div style="width:900px; margin:auto">
  <form action="${pageContext.request.contextPath}/dish/addDishImageSubmit.action" method="post" enctype="multipart/form-data">
   	<input type="hidden" name="dishid" value="${dish.id }">
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >请添加图片</td>
       <td>
	       <div id="images">
				<input type="button" value="addImages" onclick="CloneNodeByid('dishImages','images')">
				<input type="button" value="removeImages" onclick="removeNodeByid('dishImages')">
				<input type="file" name="dishImages" id="dishImages">
			</div>
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




<%-- 为${dish.name}添加图片
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/dish/addDishImageSubmit.action" method="post" enctype="multipart/form-data">
	请添加图片:
	<input type="hidden" name="dishid" value="${dish.id }">
	<div id="images">
		<input type="button" value="addImages" onclick="CloneNodeByid('dishImages','images')">
		<input type="button" value="removeImages" onclick="removeNodeByid('dishImages')"><br/>
		<input type="file" name="dishImages" id="dishImages"><br>
	</div>
	<input type="submit" value="submit"/>
</form> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dish/saveoredit.js"></script>
</html>