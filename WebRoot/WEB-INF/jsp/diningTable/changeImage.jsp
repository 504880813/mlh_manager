<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改餐桌图片</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改餐桌图片信息</strong></div>
   <div style="width:900px; margin:auto">
 <form id="diningTabledataForm" action="${pageContext.request.contextPath}/diningTable/changeImageSubmit.action" method="post" enctype="multipart/form-data">
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >餐桌空闲时图片:</td>
       <td>
	       <input type="file" name="freeimageFile" />
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >餐桌繁忙时图片:</td>
       <td>
	       <input type="file" name="busyimageFile" />
	   </td>
     </tr>
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





<%-- 餐桌信息：
<br />
<form action="${pageContext.request.contextPath}/diningTable/changeImageSubmit.action" method="post" enctype="multipart/form-data">
		 餐桌空闲时图片:<input type="file" name="freeimageFile" />
		餐桌繁忙时图片:<input type="file" name="busyimageFile" />
		<input type="submit" value="submit">
</form> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/diningTable/saveOrEditdiningTable.js "></script>
</html>