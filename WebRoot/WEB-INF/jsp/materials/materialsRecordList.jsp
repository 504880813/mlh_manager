<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>原料存取记录列表</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right"  id="mainFrame">
     
  <div class="right_cont">
   
   <div class="title_right"><strong>原料存取记录查询</strong></div>  
       <div style="width:900px; margin:auto">
<form id="selectRecordForm" action="${pageContext.request.contextPath }/materials/findmaterialsRecordofNameAndTimeofJson.action" method="post">
       <table class="table table-bordered">
         <tr>
      <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">原料名</td>
     <td width="23%">
        <input class="span1-1" type="text" id="name" name="name"/>
        <input type="button" value="选择原料" onclick="showmaterials()"/>
	       <div id="materialsList" style="display:none">
				<c:forEach items="${custommaterialsList }" var="materials">
					<input type="radio" onclick="Selectthis('${materials.id}','${materials.name}')">${materials.name} <br>
				</c:forEach>
			</div>
     </td>
     <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">起始时间：</td>
     <td width="23%">
     <input type="text" class="laydate-icon span1-1" id="startTime" name="startTime" id="startTime" readonly="readonly" />
     </td>
     <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">结束时间：</td>
     <td width="23%">
     <input type="text"  class="laydate-icon  span1-1" id="endTime" name="endTime" readonly="readonly"/>
     </td>
     </tr>
       </table>
       <table  class="margin-bottom-20 table  no-border" >
        <tr>
     	<td class="text-center"><input type="submit" value="查询" class="btn btn-info submit" style="width:80px;" /></td>
     </tr>
 </table>
   </form>
       <table class="table table-bordered table-hover table-striped">
         <tbody id="recordMessage">
           <tr align="center">
             <td><strong>原料名</strong></td>
             <td><strong>存取量</strong></td>
             <td><strong>存/取</strong></td>
             <td><strong>存取时间</strong></td>
           </tr>
         <!--   <tr align="center">
             <td>1</td>
             <td>华商汇二部分理处</td>
             <td>18701</td>
             <td>110517</td>
             <td><a id="DataGrid1_ctl03_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl03$LinkButton1','')">详细</a></td>
           </tr> -->
         </tbody>
       </table>
   </div>
     </div>     
  </div>
<%@ include file="/JspbaseTemplate/footer.jsp" %> 
























<%-- <form action="${pageContext.request.contextPath }/materials/findmaterialsRecordofNameAndTime.action" method="post">
      <input >
</form> --%>
<%-- 原料存取记录列表：
<table width="100%" border=1>
<tr>
   <form id="queryform" action="${pageContext.request.contextPath }/materials/findmaterialsRecordofNameAndTime.action" method="post">
	<td><input type="hidden" name="name"></td>
	<td>起始时间<input type="text" maxlength="100" name="startTime"  onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss',0,-150)" readonly="readonly" /></td>
	<td>结束时间<input type="text" maxlength="100" name="endTime"  onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss',0,-150)" readonly="readonly" /></td>
	<td><input type="button" value="查询" onclick="submitQuery()"></td>
   </form>
</tr>
<tr>
	<td>原料名</td>
	<td>存取量</td>
	<td>存/取</td>
	<td>存取时间</td>
</tr>
<c:forEach items="${materialsRecords}" var="materialsRecord">
<tr>	
	<c:forEach items="${materialsList}" var="materials">
		<c:if test="${ materialsRecord.materialsId==materials.id}">
			<td class="materialsName">
			${materials.name}
			</td>
		</c:if>
	</c:forEach>
	<td>${materialsRecord.materialsSurplus}${materialsRecord.materialsUnit}</td>
	<td>${materialsRecord.save=='true'?'存':'取'}</td>
	<td><fmt:formatDate value="${materialsRecord.time}" type="both"/></td>
</tr>
</c:forEach>
</table> --%>
</body>
<link href="${pageContext.request.contextPath }/js/system/laydate/need/laydate.css" rel="stylesheet" type="text/css">
<link id="LayDateSkin" href="${pageContext.request.contextPath }/js/system/laydate/skins/molv/laydate.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/materials/materialsRecord.js"></script>
</html>