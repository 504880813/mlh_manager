
//初始化
$(function(){
	$("#rightForm").validate({
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
			   required:"请录入权限名",
		   },
		   url:{
			   required:"请录入权限url",
		   },
	  }
	 });
});