<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡等级信息列表</title>
</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small"   uri="${pageContext.request.contextPath }/card/addcardLevel.action">
   <i class="icon-plus icon-white"></i> 添加会员等级信息</random:Right_A>
   </span>
   <strong>会员等级信息管理</strong>
   </div>
   
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						会员卡等级信息管理
					</h3>
				</div>
	</div>
</div>
   
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>序号</strong></td>
         <td nowrap="nowrap"><strong>名称</strong></td>
         <td nowrap="nowrap"><strong>折扣</strong></td>
         <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
         
         <c:forEach items="${cardLevels}" var="cardLevel">
			 <tr align="center">	
				<td nowrap="nowrap">${cardLevel.id}</td>
				<td nowrap="nowrap">${cardLevel.cardlevel}</td>
				<td nowrap="nowrap">${cardLevel.discount}折</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/card/editcardLevel.action?id=${cardLevel.id}">修改</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/card/deletecardLevel.action?id=${cardLevel.id}">删除</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 
</body>
</html>