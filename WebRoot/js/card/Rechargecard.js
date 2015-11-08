//初始化
$(function(){
	$("#RechargeForm").validate({
	   rules: {
		   RechargeMoney:{
			   required:true,
			   number:true
		   },
	  },
	   messages: {
		   RechargeMoney:{
			   required:"请录入充值金额",
			   number:"金额必须为数字"
		   },
	  }
	 });
});