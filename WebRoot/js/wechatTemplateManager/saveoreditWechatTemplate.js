
//初始化
$(function(){
	$("#wechatTemplateForm").validate({
	   rules: {
		   name:{
			   required:true
		   },
		   templateId:{
			   required:true,
		   },
		   topcolor:{
			   required:true,
		   },
	  },
	   messages: {
		   name:{
			   required:"请录入微信模板名",
		   },
		   templateId:{
			   required:"请录入微信模板id",
		   },
		   topcolor:{
			   required:"请录入微信模板背景色",
		   },
	  }
	 });
});