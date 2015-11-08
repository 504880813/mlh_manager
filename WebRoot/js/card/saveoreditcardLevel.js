

//初始化
$(function(){
	$("#cardLevelchangeForm").validate({
	   rules: {
		   cardlevel:{
			   required:true
		   },
		   discount:{
			   required:true,
			   number:true
		   }
	  },
	   messages: {
		   cardlevel:{
			   required:"请录入会员卡等级",
		   },
		   discount:{
			   required:"请录入等级折扣",
			   number:"会员卡等级折扣必须为数字"
		   }
	   }
	 });
});
