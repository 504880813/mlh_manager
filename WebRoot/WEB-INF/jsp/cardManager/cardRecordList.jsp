<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡消费记录列表</title>
</head>
<body>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right"  id="mainFrame">
     
  <div class="right_cont">
   
   <div class="title_right"><strong>会员卡消费查询</strong></div>  
       <div style="width:900px; margin:auto">
<form id="selectRecordForm" action="${pageContext.request.contextPath }/card/selectAllRecordsBycardidofjson.action" method="post">
       <table class="table table-bordered">
         <tr>
      <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">卡号</td>
     <td width="23%"><input type="text"  class="span1-1" id="cardid" name="cardid" /></td>
     <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">消费开始时间：</td>
     <td width="23%"><input type="text"  class="laydate-icon span1-1" id="startTime" name="startTime" /></td>
     <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">消费结束时间：</td>
     <td width="23%"><input type="text"  class="laydate-icon  span1-1" id="endTime" name="endTime"/></td>
     </tr>
       </table>
       <table  class="margin-bottom-20 table  no-border" >
        <tr>
     	<td class="text-center"><input type="submit" value="查询" class="btn btn-info submit" style="width:80px;"/></td>
     </tr>
 </table>
   </form>
       <table class="table table-bordered table-hover table-striped">
         <tbody id="recordMessage">
           <tr align="center">
             <td><strong>卡号</strong></td>
             <td><strong>消费金额</strong></td>
             <td><strong>消费时间</strong></td>
             <td><strong> </strong></td>
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


<%-- 
消费记录列表：
<table width="100%" border=1>
<tr>
	<td>卡号</td>
	<td>消费金额</td>
	<td>消费时间</td>
</tr>
<c:forEach items="${cardRecords}" var="cardRecord">
<tr>	
	<td>${cardRecord.cardId}</td>
	<td>${cardRecord.expense}</td>
	<td><fmt:formatDate value="${cardRecord.time}" type="both"/></td>
</tr>
</c:forEach>
</table> --%>
</body>
<link href="${pageContext.request.contextPath }/js/system/laydate/need/laydate.css" rel="stylesheet" type="text/css">
<link id="LayDateSkin" href="${pageContext.request.contextPath }/js/system/laydate/skins/molv/laydate.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/card/cardRecordList.js"></script>
</html>