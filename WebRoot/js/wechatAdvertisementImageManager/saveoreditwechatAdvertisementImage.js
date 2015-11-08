
//初始化
$(function(){
	$("#wechatAdvertisementImageForm").validate({
	   rules: {
		   name:{
			   required:true
		   },
		   imageFile:{
			   required:true,
		   },
	  },
	   messages: {
		   name:{
			   required:"请录入微信广告图片名",
		   },
		   imageFile:{
			   required:"请选项微信广告图片",
		   },
	  }
	 });
});