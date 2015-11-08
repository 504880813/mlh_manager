
//初始化
$(function(){
	$("#wechatuserForm").validate({
	   rules: {
		   appid:{
			   required:true
		   },
		   appsecret:{
			   required:true,
		   },
	  },
	   messages: {
		   appid:{
			   required:"请录入appid",
		   },
		   appsecret:{
			   required:"请录入appsecret",
		   },
	  }
	 });
});