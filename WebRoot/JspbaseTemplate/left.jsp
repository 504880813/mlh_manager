<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="random" uri="http://www.rms.com/CustomTag" %>

<div id="middle">
<div class="left">
<script type="text/javascript">
var myMenu;
window.onload = function() {
	myMenu = new SDMenu("my_menu");
	myMenu.init();
};
</script>

<div id="my_menu" class="sdmenu">
	<div class="collapsed">
		<span>订单和收银</span>
		<random:Right_A uri="${pageContext.request.contextPath }/diningTable/getAllDiningTableoforder.action">订单流程</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/order/getAllOrderofNotCheckout.action">收银界面</random:Right_A>
	</div>
	<div class="collapsed">
		<span>查询服务</span>
		<random:Right_A uri="${pageContext.request.contextPath }/card/selectRecordsPage.action">会员卡消费记录查询</random:Right_A>
						<random:Right_A uri="${pageContext.request.contextPath }/materials/findmaterialsRecordPage.action">原料存取记录查询</random:Right_A>
	</div>
	<div class="collapsed">
		<span>会员卡管理</span>
		<random:Right_A uri="${pageContext.request.contextPath }/card/getAllcard.action">会员卡列表</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/card/getAllcardLevel.action">会员卡等级列表</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/card/getMemberCardId.action">会员卡缴费</random:Right_A>
	</div>
	
	<div class="collapsed">
		<span>基础数据管理</span>
		<random:Right_A uri="${pageContext.request.contextPath }/diningTable/getAllDiningTableofManager.action">餐桌管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/category/findAllcategory.action">分类管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/materials/findAllmaterials.action">原料管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/dish/findAllDish.action">菜品管理</random:Right_A>
	</div>
	<div class="collapsed">
		<span>系统数据管理</span>
		<random:Right_A uri="${pageContext.request.contextPath }/user/getAllUserofManager.action">系统用户管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/right/getAllRightofManager.action">权限管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/role/getAllRoleofManager.action">角色管理</random:Right_A>
	</div>
	<div class="collapsed">
		<span>微信管理</span>
		<random:Right_A uri="${pageContext.request.contextPath }/wechatAdvertisementImage/getAllAdvertisementImage.action">微信广告图片管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/wechatuser/getAllUser.action">微信公众号管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/wechatTemplate/getAllTemplate.action">微信消息模板管理</random:Right_A>
		<random:Right_A uri="${pageContext.request.contextPath }/wechatInterface/getAllInterface.action">微信接口url管理</random:Right_A>
   </div>
 
	</div>
</div>
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script>
