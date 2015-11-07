<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>进货</strong></div>
   <div style="width:900px; margin:auto">
  <form action="${pageContext.request.contextPath}/materials/purchaseSubMit.action" method="post">
   <table  class="table table-bordered">
     <tbody>
     <tr>
       <td align="right" bgcolor="#f1f1f1" >原料名 </td>
       <td>
	       <input type="text" name="name"/><input type="button" value="选择原料" onclick="showmaterials()"/>
	       <div id="materialsList" style="display:none">
				<c:forEach items="${custommaterialsList }" var="materials">
					<input type="radio" onclick="Selectthis('${materials.id}','${materials.name}')">${materials.name} <br>
				</c:forEach>
			</div>
	   </td>
     </tr>
         <tr>
       <td align="right" bgcolor="#f1f1f1" >进货量 </td>
       <td>
	       <input type="text" name="surplus"/><input type="text" name="unit" value="g" readonly="readonly"/>
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




















<%-- <c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/materials/purchaseSubMit.action" method="post">
	原料名<input type="text" name="name"/><input type="button" value="选择原料" onclick="showmaterials()"/> <br />
	<div id="materialsList" style="display:none">
		<c:forEach items="${custommaterialsList }" var="materials">
			<input type="radio" onclick="Selectthis('${materials.id}','${materials.name}')">${materials.name} <br>
		</c:forEach>
	</div>
	进货量<input type="text" name="surplus"/><input type="text" name="unit" value="g" readonly="readonly"/>
	<input type="submit" value="submit"/>
</form> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/materials/purchase.js"></script>
</html>