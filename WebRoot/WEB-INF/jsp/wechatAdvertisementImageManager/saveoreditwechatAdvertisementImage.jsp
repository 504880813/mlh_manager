<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改本地微信广告图片</title>
</head>
<body>


<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改本地微信广告图片信息</strong></div>
   <div style="width:900px; margin:auto">
<form action="${pageContext.request.contextPath}/wechatAdvertisementImage/addoreditwechatAdvertisementImageSubmit.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${wechatAdvertisementImage.id}" />
	<input type="hidden" name="path" value="${ wechatAdvertisementImage.path}">
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >微信广告图片名称</td>
       <td>
       		<input type="text" name="name" value="${wechatAdvertisementImage.name }" />
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >微信广告图片使用状态</td>
       <td>
	       <select name="usingstatus">
				<c:if test="${wechatAdvertisementImage.usingstatus==true}">
					<option value="true" selected="selected">使用</option>
					<option value="false">废弃</option>
				</c:if>
				<c:if test="${wechatAdvertisementImage.usingstatus==false}">
					<option value="true">使用</option>
					<option value="false" selected="selected">废弃</option>
				</c:if>
				<c:if test="${wechatAdvertisementImage.usingstatus!=false && wechatAdvertisementImage.usingstatus!=true}">
					<option value="true">使用</option>
					<option value="false">废弃</option>
				</c:if>
			</select>
	   </td>
     </tr>
         <tr>
       <td align="right" bgcolor="#f1f1f1" >微信广告图片</td>
       <td>
	       <input type="file" name="imageFile" />
	   </td>
     </tr>
          <tr>
       <td align="right" bgcolor="#f1f1f1" >微信广告图片描述</td>
       <td>
	       <input type="text" name="description" value="${wechatAdvertisementImage.description}" />
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







<%-- 
本地微信广告图片信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/wechatAdvertisementImage/addoreditwechatAdvertisementImageSubmit.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${wechatAdvertisementImage.id}" />
	<input type="hidden" name="path" value="${ wechatAdvertisementImage.path}">
	微信广告图片名称<input type="text" name="name" value="${wechatAdvertisementImage.name }" />
	微信广告图片使用状态
	<select name="usingstatus">
		<c:if test="${wechatAdvertisementImage.usingstatus==true}">
			<option value="true" selected="selected">使用</option>
			<option value="false">废弃</option>
		</c:if>
		<c:if test="${wechatAdvertisementImage.usingstatus==false}">
			<option value="true">使用</option>
			<option value="false" selected="selected">废弃</option>
		</c:if>
		<c:if test="${wechatAdvertisementImage.usingstatus!=false && wechatAdvertisementImage.usingstatus!=true}">
			<option value="true">使用</option>
			<option value="false">废弃</option>
		</c:if>
	</select>
	微信广告图片<input type="file" name="imageFile" />
	微信广告图片描述<input type="text" name="description" value="${wechatAdvertisementImage.description}" />
	<input type="submit" value="submit"/>
</form> --%>
</body>
</html>