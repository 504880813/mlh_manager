
//初始化
$(function(){
	$("#wechatInterfaceForm").validate({
	   rules: {
		   name:{
			   required:true
		   },
		   url:{
			   required:true,
		   },
	  },
	   messages: {
		   name:{
			   required:"请录入微信接口调用名称",
		   },
		   url:{
			   required:"请录入微信接口调用url",
		   },
	  }
	 });
});