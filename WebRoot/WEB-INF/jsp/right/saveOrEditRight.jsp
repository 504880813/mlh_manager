<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改权限</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改权限信息</strong></div>
   <div style="width:900px; margin:auto">
 <form id="rightForm" action="${pageContext.request.contextPath}/right/${right.id ==null ? 'addrightSubmit' : 'editrightSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${right.id}" />
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >权限名称</td>
       <td>
	       <input type="text" id="name" name="name" value="${right.name}" > 
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >权限url</td>
       <td>
	       <input type="text" id="url" name="url" value="${right.url}" > 
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >权限描述</td>
       <td>
	       <input type="text" name="description" value="${right.description}" > 
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >权限码</td>
       <td>
	       <input type="text" name="code" value="${right.code}" readonly="readonly">
	   </td>
     </tr>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >权限位</td>
       <td>
	       <input type="text" name="pos" value="${right.pos}" readonly="readonly"> 
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >公共资源</td>
       <td>
	       <c:if test="${right.id ==null}">
				是<input id="common" name="common" type="radio" value="true"/> 
				不是<input id="common" name="common" type="radio" value="false"/> 
		   </c:if>
			<c:if test="${right.id !=null}">
				<c:if test="${right.common}">
					是<input id="common" name="common" type="radio" value="true" checked/> 
					不是<input id="common" name="common" type="radio" value="false"/> 
				</c:if>
				<c:if test="${!right.common}">
					是<input id="common" name="common" type="radio" value="true" /> 
					不是<input id="common" name="common" type="radio" value="false" checked/> 
				</c:if>
			</c:if>
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






<%-- 
权限信息：
<br />
<form action="${pageContext.request.contextPath}/right/${right.id ==null ? 'addrightSubmit' : 'editrightSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${right.id}" />
	权限名称<input type="text" name="name" value="${right.name}" > <br />
	权限url<input type="text" name="url" value="${right.url}" > <br />
	权限描述<input type="text" name="description" value="${right.description}" > <br />
	权限码<input type="text" name="code" value="${right.code}" > <br />
	权限位<input type="text" name="pos" value="${right.pos}" > <br />
	<c:if test="${right.id ==null}">
		公共资源<br>
		是<input id="common" name="common" type="radio" value="true"/> 
		不是<input id="common" name="common" type="radio" value="false"/> 
	</c:if>
	<c:if test="${right.id !=null}">
		<c:if test="${right.common}">
			公共资源<br>
			是<input id="common" name="common" type="radio" value="true" checked/> 
			不是<input id="common" name="common" type="radio" value="false"/> 
		</c:if>
		<c:if test="${!right.common}">
			公共资源<br>
			是<input id="common" name="common" type="radio" value="true" /> 
			不是<input id="common" name="common" type="radio" value="false" checked/> 
		</c:if>
	</c:if>
	<input type="submit" value="submit"/>
</form> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/right/saveOrEditRight.js"></script>
</html>