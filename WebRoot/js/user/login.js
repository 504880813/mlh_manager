
//初始化
$(function(){
	$("#loginForm").validate({
	   rules: {
		   username:{
			   required:true
		   },
		   password:{
			   required:true,
		   },
	  },
	   messages: {
		   username:{
			   required:"请录入用户名",
		   },
		   password:{
			   required:"请录入用户密码",
		   },
	  }
	 });
});
