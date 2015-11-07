<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡列表</title>
</head>
<body>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>
<div class="right" id="mainFrame">
     
<div class="right_cont">
   <div class="title_right"><span class="pull-right margin-bottom-5">
   <random:Right_A cssclass="btn btn-info btn-small"   uri="${pageContext.request.contextPath }/card/addcard.action">
   <i class="icon-plus icon-white"></i> 添加会员卡</random:Right_A>
   </span>
   <strong>会员卡管理</strong>
   </div>
   <div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						会员卡管理
					</h3>
				</div>
	</div>
</div>
   <table class="table table-bordered table-striped table-hover">
     <tbody>
       <tr align="center">
         <td nowrap="nowrap"><strong>卡号</strong></td>
		 <td nowrap="nowrap"><strong>主卡号</strong></td>
		 <td nowrap="nowrap"><strong>会员卡等级</strong></td>
		 <td nowrap="nowrap"><strong>用户名</strong></td>
		 <td nowrap="nowrap"><strong>电话号码</strong></td>
		 <td nowrap="nowrap"><strong>微信是否关联</strong></td>
		 <td nowrap="nowrap"><strong>使用状态</strong></td>
		 <td nowrap="nowrap"><strong>余额</strong></td>
		 <td nowrap="nowrap"><strong>总积分</strong></td>
		 <td nowrap="nowrap"><strong>当月积分</strong></td>
		 <td nowrap="nowrap" width="80"><strong>&nbsp;操作&nbsp;</strong></td>
         </tr>
		<c:forEach items="${cards}" var="card">
			<tr align="center">	
				<td nowrap="nowrap">${card.cardid}</td>
				<td nowrap="nowrap">${card.belongsCardid==null?'是主卡':card.belongsCardid}</td>
				<td nowrap="nowrap">${card.level=='-1'?'副卡':card.level}</td>
				<td nowrap="nowrap">${card.username}</td>
				<td nowrap="nowrap">${card.phone}</td>
				<td nowrap="nowrap">${card.wechatOpenid==null||card.wechatOpenid==""?'没关联':'关联'}</td>
				<td nowrap="nowrap">${card.isavailable==true?'正常使用':'冻结'}</td>
				<td nowrap="nowrap">${card.money}</td>
				<td nowrap="nowrap">${card.allIntegral}</td>
				<td nowrap="nowrap">${card.monthIntegral}</td>
				<td nowrap="nowrap">
				<random:Right_A uri="${pageContext.request.contextPath }/card/editcard.action?id=${card.id}">修改基础信息</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/card/deletecard.action?id=${card.id}">删除</random:Right_A>
				<c:if test="${card.wechatOpenid!=null&&card.wechatOpenid!=''}">
				<random:Right_A uri="${pageContext.request.contextPath }/card/getAllTemplateTosend.action?useropenid=${card.wechatOpenid}">发送模板消息</random:Right_A>
				</c:if>
				<random:Right_A uri="${pageContext.request.contextPath }/card/changecardstatus.action?id=${card.id}&isavailable=${card.isavailable}">冻结/激活</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/card/Rechargecard.action?id=${card.id}">充值</random:Right_A>
				<random:Right_A uri="${pageContext.request.contextPath }/card/ReapplyCard.action?cardid=${card.cardid }">补办会员卡</random:Right_A>
				</td>
			</tr>
		</c:forEach>
     </tbody>
   </table>
</div>    
<%@ include file="/JspbaseTemplate/footer.jsp" %> 

<%-- <form action="${pageContext.request.contextPath }/card/selectAllRecordsBycardid.action" method="post">
<input type="text" name="cardid" /><br/>
<input type="submit" value="查询" />
</form> --%>


</body>
</html>