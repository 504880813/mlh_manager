<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改会员卡等级信息</title>
</head>
<body>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改会员卡等级信息</strong></div>
   <div style="width:900px; margin:auto">
   <form action="${pageContext.request.contextPath}/card/${cardLevel.id ==null ? 'addcardLevelSubmit' : 'editcardLevelSubmit'}.action" method="post">
   <table class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >会员卡等级名称：</td>
       <td><input name="cardlevel" id="cardlevel" class="span1-1" type="text" value="${cardLevel.cardlevel}"></td>
     </tr>
     <tr>
     	<td align="right" bgcolor="#f1f1f1">会员卡等级折扣：</td>
       <td><input name="discount" id="discount" class="span1-1" type="text" value="${cardLevel.discount}">折</td>
     </tr>
   	</tbody>
   </table>
   <table class="margin-bottom-20 table  no-border">
        <tbody><tr>
     	<td class="text-center"><input value="确定" class="btn btn-info " style="width:80px;" type="submit"></td>
     </tr>
 	</tbody></table>
   </form>   
   </div> 
     </div>     
     </div>

<%@ include file="/JspbaseTemplate/footer.jsp" %> 
</body>
</html>